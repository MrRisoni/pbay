package core;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.HibernateUtil;
import models.JackSonViewer;
import models.items.Listings;
import models.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import responses.ListingCustomRepo;
import spring_repos.ListingRepo;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class ListingController {

    @Autowired
    ListingRepo listRepo;

    @RequestMapping(value = "/api/listing", method = RequestMethod.GET)
    public String getItemDetails()
    {
     /*  Optional<Listings> listFound = listRepo.findById(3L);
        ListingCustomRepo.setEm(HibernateUtil.getEM());
        HashMap<String,Object> rsp = new HashMap<>();
        rsp.put("item",listFound.orElse(null));
        rsp.put("soldLastDays", ListingCustomRepo.itemsSoldLastDays(4L));
        rsp.put("bids24h",ListingCustomRepo.getTotalBids24H(4L));
        return rsp; */

        try {
            Optional<Listings> fetchedListing = listRepo.findById(3L);
            Listings returnedListing = fetchedListing.orElse(null);

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            return mapper.writerWithView(JackSonViewer.IListing.class).writeValueAsString(returnedListing);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return ex.getMessage();
        }

    }
}
