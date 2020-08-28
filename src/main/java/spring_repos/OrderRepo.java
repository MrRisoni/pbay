package spring_repos;

import models.orders.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends CrudRepository<Orders,Long> {
}
