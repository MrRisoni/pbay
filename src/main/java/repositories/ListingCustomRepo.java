package repositories;

import javax.persistence.EntityManager;
import java.util.List;

public class ListingCustomRepo {

    private static EntityManager em;

    public static int getTotalBids24H(Long listingId)
    {

        List<Object> data= em.createNativeQuery(" SELECT COUNT(id) AS totalBids FROM biddings " +
                " WHERE active = 1 AND listing_id = :listingId " +
                "  AND DATEDIFF(DAY, created_at,GETDATE()) <=2 " +
                "  AND DATEDIFF(DAY,created_at, GETDATE()) >=0")
                .setParameter("listingId",listingId).getResultList();
        if (data.size() ==0) {
            return 0;
        }
        else {
            return Integer.parseInt(data.get(0).toString());
        }
    }

    public static int itemsSoldLastDays(Long listingId)
    {
        List<Object> soldList = em.createNativeQuery("SELECT COUNT(O.id) AS soldLastDays " +
                "  FROM  listings L  " +
                "  JOIN selling S ON S.id = L.selling_id " +
                "  JOIN  order_items OI ON OI.product_id = S.id  " +
                "  JOIN  orders O ON O.id =  OI.order_id " +
                "  WHERE L.id =:listingId AND OI.is_void = 0 " +
                "  AND O.success = 1 " +
                "  AND DATEDIFF(DAY,O.created_at,GETDATE()) <=2 " +
                "  AND DATEDIFF(DAY, O.created_at,GETDATE()) >=0")
                .setParameter("listingId",listingId).getResultList();

        if (soldList.size() ==0) {
            return 0;
        }
        else {
            return Integer.parseInt(soldList.get(0).toString());
        }
    }

    public static void setEm(EntityManager em) {
        ListingCustomRepo.em = em;
    }
}
