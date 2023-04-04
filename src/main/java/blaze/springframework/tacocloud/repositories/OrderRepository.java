package blaze.springframework.tacocloud.repositories;

import blaze.springframework.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
