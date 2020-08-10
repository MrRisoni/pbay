package core;


import models.Listing;
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

    @RequestMapping(value = "/listing", method = RequestMethod.GET)
    public HashMap<String,Object> getItemDetails()
    {
        Optional<Listing> listFound = listRepo.findById(4L);

        HashMap<String,Object> rsp = new HashMap<>();
        rsp.put("item",listFound.orElse(null));
        rsp.put("soldLastDays", ListingCustomRepo.itemsSoldLastDays(4L));
        return rsp;
    }
}
