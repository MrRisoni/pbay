package core;


import models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.ListingRepo;

import java.util.Optional;

@RestController
public class ListingController {

    @Autowired
    ListingRepo listRepo;

    @RequestMapping(value = "/listing", method = RequestMethod.GET)
    public Listing getListingDetails()
    {
        Optional<Listing> listFound = listRepo.findById(4L);
        return listFound.orElse(null);
    }
}
