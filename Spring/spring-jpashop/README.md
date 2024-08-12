# 스프링부트와 JPA 활용1

# section1. 프로젝트 환경설정
## 1. Connection Pool
일반적으로 데이터 연동은 웹 애플리케이션이 필요할 때마다 데이터베이스에 연결하여 작업하는 방식이다.  
하지만 필요할 때마다 연동해서 작업할 경우 데이터베이스 연결에 시간이 많이 걸리는 문제가 발생한다.  

이 문제를 해결하기 위해서 웹 애플리케이션이 실행됨과 동시에 연동할 데이터베이스와의 연결을 미리 설정해둔다.  
그리고 필요할 때마다 미리 연결해 놓은 상태를 이용해 빠르게 데이터베이스와 연동하여 작업을 한다.

**이렇게 미리 데이터베이스와 연결시킨 상태를 유지하는 기술**을 Connection Pool(CP) 라고 한다.

### ✅ Spring Connection Pool
자바에서는 기본적으로 `DataSource` 인터페이스를 사용하여 `Connection Pool`을 관리한다.  
Spring 에서는 사용자가 직접 `connection`을 관리할 필요없이 자동화된 기법들을 제공한다.  
SpringBoot 2.0 이전에는 `tomcat-jdbc`를 사용하다  
2.0 이후부터는 `HikariCP`를 기본 옵션으로 채택하고 있다.

## 2. CQS pattern
|       Command        |                      Query                       |
|:--------------------:|:------------------------------------------------:|
| 객체 상태를 변경하는 작업을 수행한다 | 객체 상태를 변경하지 않으며, 오직 데이터를 읽기만 한다<br>(사이드 이펙트가 없다) |
|     값을 반환하지 않는다      |                객체의 상태를 조회하고 반환한다                 |
|  데이터 저장 or 업데이트 메소드  |            특정 데이터 조회 or 계산된 값 반환 메소드             |

> ⭐️ 중요한점  
> **하나의 메소드가 command와 query 둘 중 하나에만 속해야 한다.**

### ✅ Command 예제
```java
private Entity em;

@Transaction
public Long save(Member member) {
    em.persist(member);    // 상태 변경: 데이터베이스에 회원 정보를 저장
    return member.getId(); // 반환값이 있음: query로도 해석될 수 있음
}
```
- 완전한 CQS 규칙을 따르지 않은 예시이다.
- 가급적 return 값을 만들지 않지만, id 값을 반환하여 다음에 조회할 때 사용할 수 있도록 한다.

```java
private Entity em;

@Transaction
public void update(Member member) {
    em.persist(member);
}
```
- 데이터에 변경이 발생하지만 아무것도 반환하지 않는다.

### ✅ Query 예제
```java
private Entity em;

@Transaction
public Member find(Long id) {
    return em.find(Member.class, id);
}
```
- 데이터에 변경이 발생하지 않고 sql query에 대한 결과값만 반환한다.

### ✅ 결론
웹 애플리케이션에서 얻는 이점이 있다기 보다는 개발 전반에 기본 개념으로 깔고 가는 것이 좋다.  
이 메서드를 호출 했을 때, 내부에서 변경(사이드 이펙트)가 일어나는 메서드인지, 내부에서 변경이 전혀 일어나지 않는 메서드인지 명확하게 분리하는 것이다.  
그렇게 되면 데이터 변경 관련 이슈가 발생했을 때, **변경이 일어나는 메서드만 찾아보면 된다.**   
변경 메서드도 변경에만 집중하면 되기 때문에 **유지보수가 더 좋아진다.** 

### ✅ 권장하는 방법
- `insert`: id만 반환한다. (아무것도 없으면 조회가 안되기 때문)
- `update`: 아무것도 반환하지 않는다.
- `select`: 내부의 변경이 없는 메서드로 설계한다.

## 3. Transactional & 영속성 컨텍스트
```java
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member: " + (findMember == member)); // findMember == member: true
    }

}
```
JPA는 기본으로 트랜잭션 단위로 영속성 컨텍스트가 부여되고 사용된다.  
트랜잭션을 선언하지 않으면 스프링 데이터 JPA가 리포지토리 코드 내부에서 트랜잭션을 별도로 사용한다.  
따라서 다음과 같이 동작한다.  
```java
memberRepository.save(member);                   // 트랜잭션 A, 영속성 컨텍스트A
memberRepository.findById(member.getId()).get(); // 트랜잭션 B, 영속성 컨텍스트B
```
`@Transactional` 먼저 선언하고 테스트를 시작하면 트랜잭션이 전파되어 다음과 같이 동작한다.  
```java
트랜잭션 Z

test()

memberRepository.save(member);                   // 트랜잭션 Z, 영속성 컨텍스트Z
memberRepository.findById(member.getId()).get(); // 트랜잭션 Z, 영속성 컨텍스트Z
```
따라서 같은 영속성 컨텍스트 안에서는 id 값이 같으면 같은 엔티티로 식별한다.