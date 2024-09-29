package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        // 트랜잭션 시작 로직
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        /* try catch 문이 없을 경우 실행이 제대로 작동되지 않았을 때
        이후에 트랜잭션이나 엔티티매니저와 관련된 로직이
        정상처리 되지 않을 수 있기 때문에 try catch 문으로 예외처리
         */
        try {
            Member member = new Member();
            member.setId(100L);
            member.setName("John");

            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            Member member2 = em.find(Member.class, 100L);
            member2.setName("Jane");
            System.out.println(member2.getName());
            member2.setName("Jullie");
            System.out.println(member2.getName());
            member2.setName("Jane");
            System.out.println(member2.getName());


            tx.commit();
        } catch (Exception e){
            // 예외의 경우 transaction을 롤백한다
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
