package spring_repos;

import models.items.Listings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepo extends CrudRepository<Listings,Long> {
}
