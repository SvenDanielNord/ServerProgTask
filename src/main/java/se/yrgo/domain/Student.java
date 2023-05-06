package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;

    @Column (name="NUM_COURSES")
    private Integer numberOfCourses;
    @Transient
    private String getEmail;

    @Embedded
    private Address address;




    public  Student(){

    }
    public Student(String name, String enrollmentID)
    {
        this.name = name;
        this.enrollmentID = enrollmentID;
//        this.tutor = tutor;
    }
    public Student(String name, String enrollmentID, String street, String city,
                   String zipcode){
        this.name = name;
        this.enrollmentID= enrollmentID;
        this.address = new Address(street,city,zipcode);
    }


    public Student(String name)
    {
        this.name = name;

        this.numberOfCourses = 10;
    }


    public int getId() {
        return id;
    }



    public void allocateTutor(Tutor tutor) {
//        this.tutor=tutor;
    }




    public String getEnrollmentID() {
        return enrollmentID;
    }

    @Override
    public String toString() {
        return "name:" + name + " lives at: " + address;
    }
}

