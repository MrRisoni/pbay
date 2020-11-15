package dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDto {

    private Long id;
    private String bankTransactionId;
    private Date createdAt;
    private BigDecimal total;
    private BigDecimal goodsTotal;
    private BigDecimal shipTotal;
    private BigDecimal fee;
    private short isSuccess;
    private short isVoid;

  /*  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(String bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }*/
}
