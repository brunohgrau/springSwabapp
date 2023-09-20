package bruno.springframework.springSwabapp.repositories;

import bruno.springframework.springSwabapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
