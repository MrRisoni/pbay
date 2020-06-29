package core;

import entities.HibernateUtil;
import entities.Listing;
import entities.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@CrossOrigin
@RestController
public class OrdersController {

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public String getOrderDetails() {
        try {
            EntityManager em = HibernateUtil.getEntityMngr();

            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Order> criteria = builder.createQuery( Order.class );
            Root<Order> root = criteria.from( Order.class );

            criteria.select( root );
            criteria.where( builder.equal( root.get( "id" ), "1" ) );

            List<Order> listedItems = em.createQuery( criteria ).getResultList();
            // everything gets fetched even product categories !!!!!
            return HibernateUtil.getObjMapper().writeValueAsString(listedItems.get(0));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }


    }
}
