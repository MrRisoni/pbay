package core;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.JackSonViewer;
import models.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.OrderRepo;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepo ordRepo;

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public String getOrderDetails()
    {
        try {
            Optional<Orders> fetchedOrder = ordRepo.findById(1L);
            Orders returnedOrder = fetchedOrder.orElse(null);

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            return mapper.writerWithView(JackSonViewer.IOrder.class).writeValueAsString(returnedOrder);


        }
        catch (Exception ex)
        {
            return ex.getMessage();
        }
    }
}
