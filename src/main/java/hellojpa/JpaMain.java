package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //emf 생성
        EntityManager em = emf.createEntityManager();
        //Entity Manager Thread간의 공유 절대 금지 항상 Close해서 초기화
        EntityTransaction tx = em.getTransaction();
        //Transaction 호출
        tx.begin();
        //Transaction 시작
        try {
            //실제 동작 코드 삽입
            Member member = new Member();
            member.setId(2L);
            member.setName("Hello!");
            em.persist(member);
            tx.commit();
            //저장
        }
        catch (Exception e){
            tx.rollback();
        }
        finally {
            em.close();
            //EntityManeger 종료 *사용후에 꼭 닫아줘야 함.
        }
        emf.close();
        //Application 완전 종료
    }
}
