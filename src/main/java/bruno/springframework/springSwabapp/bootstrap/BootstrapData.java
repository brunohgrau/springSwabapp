package bruno.springframework.springSwabapp.bootstrap;

import bruno.springframework.springSwabapp.domain.Author;
import bruno.springframework.springSwabapp.domain.Book;
import bruno.springframework.springSwabapp.repositories.AuthorRepository;
import bruno.springframework.springSwabapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Jones");
        Book noEJB = new Book("JSEE","323221");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books:" + bookRepository.count());

    }
}
