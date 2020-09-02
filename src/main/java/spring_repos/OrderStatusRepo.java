package spring_repos;

import models.orders.OrderStatuses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepo extends CrudRepository<OrderStatuses,Short> {
    OrderStatuses findOneByTitle(String pending);

}
