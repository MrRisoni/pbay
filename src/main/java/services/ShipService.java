package services;

import models.items.ShippingCosts;
import models.items.ShippingCostsExceptions;
import models.users.ShippingAddresses;
import org.springframework.beans.factory.annotation.Autowired;
import pojos.Basket;
import pojos.BasketItem;
import spring_repos.ShippingAddressRepo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ShipService {

    private BigDecimal shipCost;

    @Autowired
    ShippingAddressRepo shipAddRp;

    private EntityManager em;

    public ShipService()
    {
        this.shipCost = new BigDecimal(0);
    }


    public BigDecimal getCost(Basket kalathi)
    {

        System.out.println("SHIP ADDD ID " + kalathi.getShipTo().getId());

        ShippingAddresses shipAdd = shipAddRp.findById(kalathi.getShipTo().getId()).orElse(null);

       // ShippingAddresses shipAdd = optShip.orElse(null);
        String countryCode = shipAdd.getCountryObj().getCode();
        String continentCode = shipAdd.getCountryObj().getCtrContinentId().getCode();

        for (BasketItem itm: kalathi.getItems()) {
            this.shipCost = new BigDecimal(0);
            List<ShippingCosts> costPerCon =
                    this.em.createQuery(" SELECT sc " +
                            "  FROM ShippingCosts " +
                            " WHERE sellingObkFKey =:slid AND continentCode =:con ")
                    .setParameter("slid",itm.getListedItem().getSellingObj().getId())
                    .setParameter("con",continentCode)
                    .getResultList();
            if (costPerCon.size() >0) {
                this.shipCost = costPerCon.get(0).getCost();

                List<ShippingCostsExceptions> costException =
                        this.em.createQuery(" SELECT sc " +
                                "  FROM ShippingCostsExceptions " +
                                " WHERE sellingObkFKey =:slid AND countryCode =:cr ")
                                .setParameter("slid",itm.getListedItem().getSellingObj().getId())
                                .setParameter("cr",countryCode)
                                .getResultList();

                if (costException.size()>0) {
                    this.shipCost = costException.get(0).getCost();
                }

            }

        }
        return this.shipCost;
    }


    public BigDecimal getShipCost() {
        return shipCost;
    }

    public void setShipCost(BigDecimal shipCost) {
        this.shipCost = shipCost;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
