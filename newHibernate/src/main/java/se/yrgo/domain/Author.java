package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private int age;
    @ManyToMany
    Set<Publisher> publisherGroup;

    public Author() {
    }

    public Author(String name) {

        this.name = name;
        this.publisherGroup = new HashSet<Publisher>();
    }

    public void addToPublisherGroup(Publisher p){
        p.getAuthors().add(this);
        this.publisherGroup.add(p);
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Author:" +
                "name: " + name + '\'' +
                ", address: " + address + '\'' +
                ", age: " + age +
                '}';
    }
}
