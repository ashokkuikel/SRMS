package com.yubaraj.srms.web.tester;

import com.yubaraj.srms.web.utilities.BCrypt;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yubaraj
 */
public class Tester {

    public static void main(String[] args) {
//        EntityManager em = null;
//        EntityManagerFactory emf = null;
//
//        try {
//            emf = Persistence.createEntityManagerFactory("srmsPU");
//            em = emf.createEntityManager();
//            System.out.println("emf---LOL--"+emf);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        System.out.println("Password for admin: "+BCrypt.hashpw("admin", BCrypt.gensalt()));
        
    }
}
