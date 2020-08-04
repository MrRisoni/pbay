package spring_repos;

import models.Listing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepo extends CrudRepository<Listing,Long> {
}
