package models.orders;

import lombok.Getter;
import lombok.Setter;
import models.users.Users;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Getter
    @Setter
    @Lob
    @Column
    private String comment;

    @Getter
    @Setter
    @Column
    private BigDecimal stars;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JoinColumn(name = "rev_usr_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userObj;

    @JoinColumn(name = "rev_ord_item_id", referencedColumnName = "itm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderItems orderItemObj;

    public Reviews() {
    }

    public Reviews(Long revId) {
        this.id = revId;
    }

    public Reviews(Long revId, String revComment, BigDecimal revStar, Date revCreatedAt) {
        this.id = revId;
        this.comment = revComment;
        this.stars = revStar;
        this.createdAt = revCreatedAt;
    }

    public Users getUserObj() {
        return userObj;
    }

    public void setUserObj(Users userObj) {
        this.userObj = userObj;
    }

    public OrderItems getOrderItemObj() {
        return orderItemObj;
    }

    public void setOrderItemObj(OrderItems orderItemObj) {
        this.orderItemObj = orderItemObj;
    }
}
