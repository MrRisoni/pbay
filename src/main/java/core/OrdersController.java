package core;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OrdersController {

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public String getOrderDetails() {
        return "sdsd";
    }
}
