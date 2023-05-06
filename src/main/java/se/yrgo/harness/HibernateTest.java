package se.yrgo.harness;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class HibernateTest {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {

        
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();


        Transaction tx = session.beginTransaction();

//        Tutor newTutor = new Tutor("ABC234", "Nahid", 38778);
//        Student student1 = new Student("Danne Dos","1-HOW-2017");
//        Student student2 = new Student("Samuel från Majorkna", "2-SAN-2018");
//        Student student3 = new Student("Hugo With The Beard", "3-NIK-2019");
//
//        newTutor.addStudentToTeachingGroup(student1);
//        newTutor.addStudentToTeachingGroup(student2);
//        newTutor.addStudentToTeachingGroup(student3);
        Tutor newTutor = (Tutor)session.get(Tutor.class, 90);
        List<Student> students = newTutor.getTeachingGroup();

        for(Student student: students) {

            System.out.println(student);
        }
        System.out.println("Students above have " + newTutor.getName() + "as teacher");

//        session.save(student1);
//        session.save(student2);
//        session.save(student3);
//        session.save(newTutor);


        tx.commit();
        session.close();

    }
    private static SessionFactory getSessionFactory(){
        if(sessionFactory ==null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}

