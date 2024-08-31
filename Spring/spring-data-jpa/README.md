# 스프링 데이터 JPA

# section1. 프로젝트 환경설정
## 1. JPA Entity에 기본생성자가 필수인 이유
JPA에서 Entity는 반드시 public 또는 protected인 기본 생성자를 가져야 한다.  



### ✅ Java Reflection API
Reflection API는 구체적인 클래스 타입을 알지 못하더라도 해당 클래스 이름을 통해 메서드, 타입, 변수 등에 접근할 수 있도록 해주는 API이다.  
Reflection을 활용하여 런타임 시점에 동적으로 클래스 객체를 생성할 수 있다.  

일반적으로 객체에 데이터를 넣기 위해서는 new 생성자 또는 setter 등이 필요하며, 접근 제어자에 따라 데이터를 넣지 못할 수도 있다.  
하지만 Entity의 모든 필드에 setter를 사용하는 것은 객체에 대한 값 변경이 어느 곳에서든 일어날 수 있어 최대한 사용을 피한다.  

Reflection API는 기본 생성자를 통해 객체를 생성하여 setter를 사용하지 않고도 데이터를 넣을 수 있다.  
또한, private 메서드에 접근할 수 있다.

Spring Data JPA에서는 이러한 Reflection API를 사용하기 때문에 기본 생성자가 필요로 하는 것이다.


# section2. 


# section3. 
## 1. Spring Data JPA는 어떻게 interface 만으로도 동작할까?

# section4.
MemberRepository Test 반환타입 부분 컬렉션과 단건 조회 반환
exception 터뜨리는게 나은지(jpa), null 반환(spring data jpa)하는게 나은지?
실무에서는 null이 넘어오는게 낫다.
java8부터 아몰랑 optional 써!
데이터 있을지 없을지 모르면 optional 타입으로 반환을 해 -> 처리가 클라이언트 쪽으로 넘어간다.