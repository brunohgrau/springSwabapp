package bruno.springframework.springSwabapp.repositories;

import bruno.springframework.springSwabapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
