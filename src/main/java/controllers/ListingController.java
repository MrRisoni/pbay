package controllers;

import dtos.ListingDto;
import models.HibernateUtil;
import models.items.Listings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import repositories.ListingCustomRepo;
import spring_repos.ListingRepo;

import java.util.Optional;

@RestController
public class ListingController {

    @Autowired
    ListingRepo listRepo;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/api/listing/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<ListingDto> getItemDetails(@PathVariable Long itemId)
    {

        try {
            Optional<Listings> fetchedListing = listRepo.findById(itemId);
            Listings returnedListing = fetchedListing.orElse(null);

            ListingCustomRepo.setEm(HibernateUtil.getEM());
            ListingDto listDto = modelMapper.map(returnedListing, ListingDto.class);
            listDto.setTotalBids(ListingCustomRepo.getTotalBids24H(itemId));
            listDto.setSoldLastDays(ListingCustomRepo.itemsSoldLastDays(itemId));
            return new ResponseEntity<>(listDto, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }
}

