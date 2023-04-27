package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String adress;
    @ManyToMany
    Set<Author> authorsWithPublisher;

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
        this.authorsWithPublisher = new HashSet<Author>();
    }
    public Set<Author> getAuthors(){
        return this.authorsWithPublisher;
    }

    public void addToPublisher(Author author){
    this.authorsWithPublisher.add(author);
    }
//    Set<Author>unmodifiable = Collections.unmodifiableSet(this.authorsWithPublisher);
//        return unmodifiable;
}
