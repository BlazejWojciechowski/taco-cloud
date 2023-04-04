package blaze.springframework.tacocloud.repositories;

import blaze.springframework.tacocloud.domain.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
