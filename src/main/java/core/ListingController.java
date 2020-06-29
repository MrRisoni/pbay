package core;


import entities.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class ListingController {

    @Value("${app.dummy_today}")
    private String dummy_today;

    @Value("${app.dummy_unix}")
    private long dummy_unix;

    @RequestMapping(value = "/api/listing", method = RequestMethod.GET)
    public String getListingDetails() {
        try {
            EntityManager em = HibernateUtil.getEntityMngr();
            Session session = HibernateUtil.getSessionFactory().openSession();

            ListingResponse rsp = new ListingResponse();
            int listingId = 1;
            int userId = 2;

            String q = "SELECT COUNT(O.ord_id) AS soldLastDays " +
                    " FROM  listings L " +
                    "  JOIN selling S ON S.sll_id = L.lis_selling_id " +
                    "  JOIN  order_items OI ON OI.itm_product_id = S.sll_id " +
                    "  JOIN  orders O ON O.ord_id =  OI.itm_order_id " +
                    "  WHERE L.lis_id = '" + String.valueOf(listingId) + "' AND OI.itm_void = 0 " +
                    "  AND O.ord_success = 1 " +
                    "  AND DATEDIFF('" + this.dummy_today +"', DATE(O.ord_created)) <=2 " +
                    "  AND DATEDIFF('" + this.dummy_today +"', DATE(O.ord_created)) >=0 ";


            List<BigInteger> soldRecords = em.createNativeQuery(q).getResultList();
System.out.println("PRINT RESULTS");
            System.out.println(soldRecords.get(0));

           rsp.setItemSoldLately(soldRecords.get(0));

            q = " SELECT COUNT(bid_id) AS totalBids FROM biddings " +
            " WHERE bid_active = 1 AND bid_listing_id = '" + String.valueOf(listingId) + "'" +
            " AND  DATEDIFF('" + this.dummy_today + "', DATE(bid_created_at)) <=2 " +
            " AND DATEDIFF('" + this.dummy_today + "', DATE(bid_created_at)) >=0 " ;
            List<BigInteger> totalBidsResults = em.createNativeQuery(q).getResultList();
            if (totalBidsResults.size() >0) {
                rsp.setTotalBidsLately(totalBidsResults.get(0));
            }


            // best bid
            List<Bidding> bids = em.createQuery(
                    "FROM entities.Bidding WHERE id = '" + String.valueOf(listingId) + "' AND active =1 ORDER BY createdAt DESC ", Bidding.class )
                    .setMaxResults(1).getResultList();

            System.out.println(bids.get(0).getPriceEur());
            rsp.setBestBid(bids.get(0).getPriceEur());
            System.out.println(bids.get(0).getCreatedAt());
           long diff = this.dummy_unix - bids.get(0).getCreatedAt().getTime();

            List<Currency> currencyList = session.createCriteria(Currency.class)
                    .list();


            //get user 's shipping addresses to calc avg cost
                Query qr = em.createNativeQuery(" SELECT DISTINCT(shp_country_id) AS id , CR.ctr_title AS title " +
                    "  FROM shipping_addresses " +
                    " JOIN countries CR ON CR.ctr_id = shp_country_id  " +
                    " WHERE shp_user_id = '" + String.valueOf(userId) + "'");
                List<Object[]> userAddrresses = qr.getResultList();
                System.out.println(userAddrresses);


                // get item info
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Listing> criteria = builder.createQuery( Listing.class );
            Root<Listing> root = criteria.from( Listing.class );
            Join<Listing, Selling> sellObjJoin = root.join("sellingObj");
            Join<Selling, Product> productJoin = sellObjJoin.join("productObj");

            criteria.select( root );
            criteria.where( builder.equal( root.get( "id" ), "1" ) );

            List<Listing> persons = em.createQuery( criteria ).getResultList();


            return HibernateUtil.getObjMapper().writeValueAsString(persons);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
