package spring_repos;


import models.general.Currencies;
import models.orders.OrderStatuses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends CrudRepository<Currencies,Short> {
    Currencies findOneByCode(String code);

}
