package bruno.springframework.springSwabapp.bootstrap;

import bruno.springframework.springSwabapp.domain.Author;
import bruno.springframework.springSwabapp.domain.Book;
import bruno.springframework.springSwabapp.domain.Publisher;
import bruno.springframework.springSwabapp.repositories.AuthorRepository;
import bruno.springframework.springSwabapp.repositories.BookRepository;
import bruno.springframework.springSwabapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Companhia das Letras");
        publisher.setCity("São Paulo");
        publisher.setState("Brasil");

        publisherRepository.save(publisher);
        System.out.println("Number of Publishers:" + publisherRepository.count());


        Author mario = new Author("Mario","De Andrade");
        Book contos = new Book("Contos","123");
        mario.getBooks().add(contos);
        contos.getAuthors().add(mario);

        contos.setPublisher(publisher);
        publisher.getBooks().add(contos);

        authorRepository.save(mario);
        bookRepository.save(contos);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Jones");
        Book noEJB = new Book("JSEE","323221");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Publisher Number of Books:" + publisher.getBooks().size());

    }
}
