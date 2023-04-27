package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    String title;
    String publisher;
    @Transient
    private Integer numberOfPages;

    @Column (name="ISBN_NUM")
    private Integer isbn;
     public Book(){}
    public Book(String title) {
        this.title = title;
    }
    @ManyToOne
    Author author;
    public Book(Integer isbn, Author author, String publisher) {
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
    }

    public void allocateAuthor(Author author){
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author.getName();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "se.yrgo.domain.Book:" +
                "isbn:" + isbn + '\'' +
                ", title:'" + title + '\'' +
                ", author:" + author.getName() + '\'' +
                ", publisher:" + publisher;
    }
}
