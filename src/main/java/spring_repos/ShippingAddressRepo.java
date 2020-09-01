package spring_repos;

import models.users.ShippingAddresses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepo extends CrudRepository<ShippingAddresses,Long> {
}
