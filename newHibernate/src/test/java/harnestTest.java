import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Author;
import se.yrgo.domain.Book;
import se.yrgo.domain.Publisher;

public class harnestTest {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {
        Book book3 = new Book("Cool ");
        Author author = new Author("Peter Siepens");
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        book1.allocateAuthor(author);
//      Book newBook = new Book("Beans");
//        newBook.allocateAuthor(author);
//
//        session.save(newBook);
        Author author2 = new Author("Zigge");
        Publisher publisher = new Publisher("Agria");
        Publisher publisher1 =  new Publisher("Zäta ab");
        session.save(author);
        session.save(author2);
        session.save(publisher);
        session.save(publisher1);


        author.addToPublisherGroup(publisher);

//        session.delete(newBook);
//        Book book2 = (Book)session.get(Book.class, 50);
//        session.save(book2);
//        System.out.println(book2.getTitle());
//        session.save(book1);
        session.save(author);
        System.out.println(author.getName());
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
