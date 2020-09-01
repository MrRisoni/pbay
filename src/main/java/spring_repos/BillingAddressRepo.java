package spring_repos;

import models.users.BillingAddresses;
import models.users.ShippingAddresses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepo extends CrudRepository<BillingAddresses,Long> {
}
