package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //emf 생성
        EntityManager em = emf.createEntityManager();
        //실제 동작 코드 삽입
        em.close();
        //emf 종료
        emf.close();
        //Application 완전 종료
    }
}
