# EXISTS VS IN
## 1. EXITS
서브쿼리가 반환하는 결과값이 있는지를 조사한다.  
단지 반환된 행이 있는지 없는지만 보고 값이 있으면 참 없으면 거짓을 반환한다.  
- 조건에 해당하는 row의 존재 유무와 이후 더 수행하지 않음
- 조건에 맞지 않는 row만 추출하고 싶으면 NOT EXISTS
- 쿼리 순서 : 메인 쿼리 -> EXISTS 쿼리

> Tip  
서브쿼리 내에서 부모쿼리의 필드를 사용할 수 있다.

- 서브쿼리에서 메인쿼리 테이블을 활용하는 형태를 연관 서브쿼리라고 한다.  
- EXISTS 다음으로 오는 SELECT에서 * 대신 아무거나 입력해도 상관없다.  
- EXISTS는 조건이 맞는 지에 대한 T/F만 확인하기 때문이다.  
- 만족하는 결과가 최소 하나가 나오면 바로 T로 판단한다.  

### 예시 코드로 확인해보자
#### `customer table`
|customer_id|customer_nm|
|-|-|
|1|홍길동|
|2|이길동|

#### `blacklist table`
|bladklist_id|customer_id|customer_nm|
|-|-|-|
|1|2|이길동|
|2||박길동|

#### `customer_order table` (홍길동씨만 주문)
|order_id|customer_id|product_id|order_price|
|-|-|-|-|
|11|1|111|1000|

### 1. EXIST 서브쿼리에 행이 하나라도 존재하면 TRUE를 반환한다.

```sql
select customer_nm
  from customer
 where exists (select customer_id from customer_order);
```
### `결과`
|customer_nm|
|-|
|홍길동|
|이길동|

### `실행 방식`
1.  customer 테이블의 첫 번째 행 (customer_id = 1, customer_nm = '홍길동')에 대해
    - EXISTS (SELECT customer_id FROM customer_order) 서브쿼리가 실행된다.
    - customer_order 테이블에는 행이 존재하므로, 서브쿼리는 TRUE를 반환한다.
2. customer 테이블의 두 번째 행 (customer_id = 2, customer_nm = '이길동')에 대해
    - EXISTS (SELECT customer_id FROM customer_order) 서브쿼리가 실행된다.
    - customer_order 테이블에는 행이 존재하므로, 서브쿼리는 TRUE를 반환한다.

- customer_order 테이블에 어떤 조건도 없으므로, 행이 하나라도 존재하면 TRUE를 반환하고 없으면 FALSE를 반환한다. 
- customer 건수만큼 EXITS 서브쿼리를 수행하고 결과 row가 존재(TRUE)면 추출한다. 

### 2. 서브쿼리 IN은 올바른 결과를 추출한다.
```sql
select customer_nm
  from customer
 where customer_id in (select customer_id from customer_order);
```
|customer_nm|
|-|
|홍길동|


### 3. 서브쿼리 EXIST를 올바르게 수정해보자.
```sql
select c.customer_nm
  from customer c
 where exists (select co.customer_id from customer_order co where c.customer_id = co.customer_id);
```
- customer_order에 조건을 달아주어 올바른 결과를 추출할 수 있도록 수정했다.

## 2. IN
서브쿼리가 반환하는 결과 집합에 대해 외부 쿼리의 값을 비교한다.
- 집합 내부에 값이 존재하는지 여부 확인
- 조건에 해당하는 row의 컬럼 비교하여 체크
- select 절에서 조회한 컬럼 값으로 비교하여 exists에 비해 성능 떨어짐
- 쿼리 순서 : IN 쿼리 -> 메인 쿼리

```sql
select customer_nm
  from customer
 where customer_id in (select customer_id from customer_order);
```

### `실행 방식`
- IN 연산자 안의 서브쿼리가 실행된다. 
- 서브쿼리는 customer_order 테이블에서 customer_id를 선택한다.
- 결과는 customer_id의 목록으로 반환된다.

```sql
select customer_id from customer_order
```
|customer_id|
|-|
|1|

- 외부쿼리는 customer 테이블의 각 행을 순차적으로 처리한다. 
- 각 행에 대해, customer_id가 서브쿼리의 결과 목록에 있는지 확인한다. 
- 목록에 존재하면 TRUE를 반환하고 외부 쿼리의 조건을 만족한다. 목록에 존재하지 않으면 FALSE를 반환하고, 조건을 만족하지 않는다.

1. customer 테이블의 첫 번째 행 (customer_id = 1, customer_nm = '홍길동')에 대해
    - customer_id가 서브쿼리의 결과 목록 (1)에 존재하는지 확인한다.
    - 존재하므로, 이 행은 최종 결과에 포함된다.

2. customer 테이블의 두 번째 행 (customer_id = 2, customer_nm = '이길동')에 대해
    - customer_id가 서브쿼리의 결과 목록 (1)에 존재하는지 확인한다.
    - 존재하지 않으므로, 이 행은 최종 결과에 포함되지 않는다.


# NOT EXISTS vs NOT IN
## 1. NOT EXISTS
```sql
select c.customer_nm
  from customer c
 where not exists (select b.customer_id from blacklist b where c.customer_id = b.customer_id);
```
|customer_nm|
|-|
|홍길동|

- 각 행에 대해 서브쿼리가 실행되어 customer_order 테이블에 해당 customer_id가 존재하지 않는지 확인한다.  
- 존재하지 않으면 TRUE, 존재하면 FALSE를 반환한다.  
- NULL 값이 영향을 받지 않는다. 서브쿼리가 조건을 만족하는지 여부만 확인하므로 NULL 값이 있어도 정확한 값을 추출한다. 

## 2. NOT IN
```sql
select c.customer_nm
  from customer c
 where not exists (select b.customer_id from blacklist b where c.customer_id = b.customer_id);
```
|customer_nm|
|-|
||
- customer_id에 NULL 값이 들어가 있다.  
- 서브쿼리 결과 목록에 NULL 값이 하나라도 있으면, NOT IN 조건은 항상 FALSE를 반환한다.  

### NOT IN 연산자에서 NULL 값 처리하기
```sql
select customer_nm
  from customer
 where customer_id not in (select customer_id from blacklist where customer_id is not null);
```
|customer_nm|
|-|
|홍길동|
- 정확한 결과를 추출하였다.


## 참고
[[MYSQL] 📚 서브쿼리 연산자 EXISTS 총정리 (성능 비교)](https://inpa.tistory.com/entry/MYSQL-%F0%9F%93%9A-%EC%84%9C%EB%B8%8C%EC%BF%BC%EB%A6%AC-%EC%97%B0%EC%82%B0%EC%9E%90-EXISTS-%EC%B4%9D%EC%A0%95%EB%A6%AC-%EC%84%B1%EB%8A%A5-%EB%B9%84%EA%B5%90#exists_vs_in_%EC%97%B0%EC%82%B0%EC%9E%90_%EC%B0%A8%EC%9D%B4)