package spring_repos;

import models.orders.OrderItemTrackHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemTrackHistoryRepo extends CrudRepository<OrderItemTrackHistory,Long> {
}
