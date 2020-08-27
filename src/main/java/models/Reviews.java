
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "reviews")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reviews.findAll", query = "SELECT r FROM Reviews r")})
public class Reviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rev_id")
    private Long revId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "rev_comment")
    private String revComment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "rev_star")
    private BigDecimal revStar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rev_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date revCreatedAt;
    @JoinColumn(name = "rev_usr_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users revUsrId;
    @JoinColumn(name = "rev_ord_item_id", referencedColumnName = "itm_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderItems revOrdItemId;

    public Reviews() {
    }

    public Reviews(Long revId) {
        this.revId = revId;
    }

    public Reviews(Long revId, String revComment, BigDecimal revStar, Date revCreatedAt) {
        this.revId = revId;
        this.revComment = revComment;
        this.revStar = revStar;
        this.revCreatedAt = revCreatedAt;
    }

    public Long getRevId() {
        return revId;
    }

    public void setRevId(Long revId) {
        this.revId = revId;
    }

    public String getRevComment() {
        return revComment;
    }

    public void setRevComment(String revComment) {
        this.revComment = revComment;
    }

    public BigDecimal getRevStar() {
        return revStar;
    }

    public void setRevStar(BigDecimal revStar) {
        this.revStar = revStar;
    }

    public Date getRevCreatedAt() {
        return revCreatedAt;
    }

    public void setRevCreatedAt(Date revCreatedAt) {
        this.revCreatedAt = revCreatedAt;
    }

    public Users getRevUsrId() {
        return revUsrId;
    }

    public void setRevUsrId(Users revUsrId) {
        this.revUsrId = revUsrId;
    }

    public OrderItems getRevOrdItemId() {
        return revOrdItemId;
    }

    public void setRevOrdItemId(OrderItems revOrdItemId) {
        this.revOrdItemId = revOrdItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (revId != null ? revId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviews)) {
            return false;
        }
        Reviews other = (Reviews) object;
        if ((this.revId == null && other.revId != null) || (this.revId != null && !this.revId.equals(other.revId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Reviews[ revId=" + revId + " ]";
    }
    
}
