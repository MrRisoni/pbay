package services;

import models.items.Listings;
import models.items.ShippingCosts;
import models.items.ShippingCostsExceptions;
import models.users.ShippingAddresses;
import org.hibernate.Hibernate;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import pojos.Basket;
import pojos.BasketItem;
import spring_repos.ListingRepo;
import spring_repos.ShippingAddressRepo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ShipService {

    private BigDecimal shipCost;

    @Autowired
    ListingRepo listRepo;

    private EntityManager em;

    public ShipService()
    {
        this.shipCost = new BigDecimal(0);
    }


    public BigDecimal getCost(Basket kalathi)
    {

        System.out.println("SHIP ADDD ID " + kalathi.getShipTo().getId());
        List<Object[]> shipAddObj = this.em.createNativeQuery(
                "SELECT cont.con_id,cn.ctr_code , cont.con_code ,cn.ctr_id "+
               "  FROM shipping_addresses sha "+
               " JOIN countries cn ON cn.ctr_id = sha.shp_country_id "+
               " JOIN continents cont ON cn.ctr_continent_id = cont.con_id "+
               " WHERE sha.shp_id = :shipId ")
                .setParameter("shipId",kalathi.getShipTo().getId())
              .getResultList();


        String countryCode = shipAddObj.get(0)[1].toString();
        String continentCode = shipAddObj.get(0)[2].toString();
        Integer continentId = Integer.valueOf(shipAddObj.get(0)[0].toString());
        Integer countryId = Integer.valueOf(shipAddObj.get(0)[3].toString());

        System.out.println("COUNTRY CODE " + countryCode);
        System.out.println("continentCode CODE " + continentCode);

        for (BasketItem itm: kalathi.getItems()) {
            this.shipCost = new BigDecimal(0);

            System.out.println("Listing id " + itm.getListedItem().getId());


            String perContinentSQL = " SELECT shc.shc_cost AS cost " +
                    "FROM   shipping_costs shc " +
                    "JOIN  listings lst ON shc.shc_selling_id = lst.lis_selling_id " +
                    "WHERE lst.lis_id = :lisId " +
                    "AND shc.shc_continent_id = :conId ";

            List<ShippingCosts> costPerCon = this.em.createNativeQuery(perContinentSQL)
                    .setParameter("lisId",itm.getListedItem().getId())
                    .setParameter("conId",continentId)
                    .unwrap(org.hibernate.query.NativeQuery.class)
                    .addScalar("cost", StandardBasicTypes.BIG_DECIMAL)
                    .setResultTransformer(Transformers.aliasToBean(ShippingCosts.class))
                    .getResultList();

            if (costPerCon.size() >0) {
                this.shipCost = costPerCon.get(0).getCost();


                String exceptionSQL = " SELECT scx.shcx_cost AS cost " +
                        "FROM    shipping_costs_exceptions scx " +
                        "JOIN  listings lst ON scx.shcx_selling_id = lst.lis_selling_id " +
                        "WHERE lst.lis_id = :lisId " +
                        "AND scx.shcx_country_id = :crnId ";

                List<ShippingCostsExceptions> costException =
                        this.em.createNativeQuery(exceptionSQL)
                                .setParameter("lisId",itm.getListedItem().getId())
                                .setParameter("crnId",countryId)
                                .unwrap(org.hibernate.query.NativeQuery.class)
                                .addScalar("cost", StandardBasicTypes.BIG_DECIMAL)
                                .setResultTransformer(Transformers.aliasToBean(ShippingCostsExceptions.class))
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
