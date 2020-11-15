package controllers;

import dtos.ListingDto;
import models.items.Listings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.ListingRepo;

import java.util.Optional;

@RestController
public class ListingController {

    @Autowired
    ListingRepo listRepo;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/api/listing", method = RequestMethod.GET)
    public ResponseEntity<ListingDto> getItemDetails()
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

            ListingDto listDto = modelMapper.map(returnedListing, ListingDto.class);
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }
}
