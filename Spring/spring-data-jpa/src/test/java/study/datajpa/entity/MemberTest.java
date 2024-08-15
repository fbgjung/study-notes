package study.datajpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        // persist: DB에 바로 insert query를 날리는 게 아니라 JPA 영속성 컨텍스트에 Member, Team을 다 모아놓는다.
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        // 초기화
        em.flush();  // 강제로 insert query를 날린다.
        em.clear(); // JPA 영속성 컨텍스트 캐시를 다 날린다.

        // 확인
        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.team = " + member.getTeam());

        }
        /*
        member = Member(id=1, username=member1, age=10)
        -> member.team = Team(id=1, name=teamA)
        member = Member(id=2, username=member2, age=20)
        -> member.team = Team(id=1, name=teamA)
        member = Member(id=3, username=member3, age=30)
        -> member.team = Team(id=2, name=teamB)
        member = Member(id=4, username=member4, age=40)
        -> member.team = Team(id=2, name=teamB)
         */

    }

}