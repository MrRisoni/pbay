package core;


import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.HibernateUtil;
import models.JackSonViewer;
import models.general.Currencies;
import models.general.Currencies_;
import models.general.Paymethods;
import models.orders.OrderStatuses;
import models.orders.Orders;
import models.users.BillingAddresses;
import models.users.ShippingAddresses;
import models.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojos.Basket;
import spring_repos.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepo ordRepo;

    @Autowired
    BillingAddressRepo billAddrRepo;

    @Autowired
    ShippingAddressRepo shipAddrRepo;

    @Autowired
    CurrencyRepo currencyRepo;

    @Autowired
    OrderStatusRepo ordStatusRepo;



    @RequestMapping(value = "/api/order/view", method = RequestMethod.GET)
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
            ex.printStackTrace();
            return ex.getMessage();
        }
    }


    @RequestMapping(value=  "/api/order/place_order" , method = RequestMethod.POST)
    public String placeOrder( @RequestBody Object postData) {
        try {
            EntityManager entityManager = HibernateUtil.getEM();

            Gson g = new Gson();
            Basket kalathi = new Gson().fromJson(g.toJson(postData), Basket.class);

            Optional<BillingAddresses> billedOptional = billAddrRepo.findById(kalathi.getBillTo().getId());
            BillingAddresses savedBilledAddress  = billedOptional.orElse(null);

            Optional<ShippingAddresses> shippedOptional = shipAddrRepo.findById(kalathi.getShipTo().getId());
            ShippingAddresses savedShipAddress  = shippedOptional.orElse(null);

            Currencies nomisma = currencyRepo.findOneByCode(kalathi.getCurrencyCode());

            Orders paraggelia = new Orders();
            paraggelia.setPayMethodObj(new Paymethods(kalathi.getPay().getId()));

            OrderStatuses stdPending = ordStatusRepo.findOneByTitle("Pending");

            paraggelia.setBillAddressObj(savedBilledAddress);
            paraggelia.setShipAddressObj(savedShipAddress);
            paraggelia.setUserObj(new Users(kalathi.getUsr().getId()));
            paraggelia.setBankTransactionId(Utils.getRandomString(15));
            paraggelia.setCurrencyObj(nomisma);
            paraggelia.setCreatedAt(new Date());

            BigDecimal total = new BigDecimal(0);
            BigDecimal goodsTotal = new BigDecimal(0);
            BigDecimal shipTotal = new BigDecimal(0);
            BigDecimal fee = new BigDecimal(0);


            paraggelia.setTotal(total);
            paraggelia.setGoodsTotal(goodsTotal);
            paraggelia.setShipTotal(shipTotal);
            paraggelia.setFee(fee);


            Orders savedOrder = ordRepo.save(paraggelia);

            

            return "foo";
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }


}
