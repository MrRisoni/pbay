package repositories;

import javax.persistence.EntityManager;
import java.util.List;

public class ListingCustomRepo {

    private static EntityManager em;

    public static int getTotalBids24H(Long listingId)
    {
        return   ( (Number) em.createNativeQuery(" SELECT COUNT(bid_id) AS totalBids FROM biddings " +
        " WHERE bid_active = 1 AND bid_listing_id = :listingId " +
        " AND DATEDIFF(CURRENT_DATE, DATE(bid_created_at)) <=2 " +
        " AND DATEDIFF(CURRENT_DATE, DATE(bid_created_at)) >=0 ")
                .setParameter("listingId",listingId).getSingleResult()).intValue();

    }

    public static int itemsSoldLastDays(Long listingId)
    {
        List<Object> soldList = em.createNativeQuery("SELECT COUNT(O.ord_id) AS soldLastDays" +
                " FROM  listings L " +
                " JOIN selling S ON S.sll_id = L.lis_selling_id" +
                " JOIN  order_items OI ON OI.itm_product_id = S.sll_id " +
                " JOIN  orders O ON O.ord_id =  OI.itm_order_id" +
                " WHERE L.lis_id = :listingId AND OI.itm_void = 0" +
                " AND O.ord_success = 1" +
                " AND DATEDIFF(CURRENT_DATE, DATE(O.ord_created)) <=2" +
                " AND DATEDIFF(CURRENT_DATE, DATE(O.ord_created)) >=0")
                .setParameter("listingId",listingId).getResultList();

            return Integer.parseInt(soldList.get(0).toString());
    }

    public static void setEm(EntityManager em) {
        ListingCustomRepo.em = em;
    }
}
