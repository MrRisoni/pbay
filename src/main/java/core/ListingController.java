package core;


import entities.HibernateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin
@RestController
public class ListingController {

    @Value("${app.dummy_today}")
    private String dummy_today;

    @RequestMapping(value = "/api/listing", method = RequestMethod.GET)
    public String getListingDetails() {
        try {
            ListingResponse rsp = new ListingResponse();
            int listingId = 1;
            String q = "SELECT COUNT(O.ord_id) AS soldLastDays " +
                    " FROM  listings L " +
                    "  JOIN selling S ON S.sll_id = L.lis_selling_id " +
                    "  JOIN  order_items OI ON OI.itm_product_id = S.sll_id " +
                    "  JOIN  orders O ON O.ord_id =  OI.itm_order_id " +
                    "  WHERE L.lis_id = '" + String.valueOf(listingId) + "' AND OI.itm_void = 0 " +
                    "  AND O.ord_success = 1 " +
                    "  AND DATEDIFF('" + this.dummy_today +"', DATE(O.ord_created)) <=2 " +
                    "  AND DATEDIFF('" + this.dummy_today +"', DATE(O.ord_created)) >=0 ";


            List<BigInteger> soldRecords = HibernateUtil.getEntityMngr().createNativeQuery(q).getResultList();
System.out.println("PRINT RESULTS");
            System.out.println(soldRecords.get(0));

           rsp.setItemSoldLately(soldRecords.get(0));
            return HibernateUtil.getObjMapper().writeValueAsString(rsp);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
