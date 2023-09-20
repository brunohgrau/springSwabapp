package bruno.springframework.springSwabapp.repositories;

import bruno.springframework.springSwabapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long>{
}
