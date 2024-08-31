package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = new Member(300L, "member300");
//            em.persist(member);
//
//            System.out.println("===================");

            tx.commit(); // 정상이면 commit
        } catch (Exception e) {
            tx.rollback(); // 아니면 rollback
        } finally {
            em.close(); // entityManager 는 사용후 꼭 닫아줘야한다.
        }
        emf.close();
    }
}
