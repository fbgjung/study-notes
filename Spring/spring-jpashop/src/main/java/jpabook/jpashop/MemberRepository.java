package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {


    @PersistenceContext // EntityManager 를 주입
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // CQS
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
