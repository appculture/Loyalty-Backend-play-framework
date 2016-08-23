package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Transaction represent some action which changed {@link Customer} points balance.
 * Transaction could be purchase or redeem.
 * <p>
 * Created by abozic on 8/18/16.
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    private String transactionId;
    @Column(columnDefinition = "timestamp default now()")
    private Date date;
    private String description;
    private double points;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
