package models;

import java.util.Date;

/**
 * Transaction represent some action which changed {@link Customer} points balance.
 * Transaction could be purchase or redeem.
 * <p>
 * Created by abozic on 8/18/16.
 */
public class Transaction {

    private String transationId;
    private Date date;
    private String description;
    private double points;
    //not in use for a moment
    //private TransactionType type;
    private Customer customer;

    public String getTransationId() {
        return transationId;
    }

    public void setTransationId(String transationId) {
        this.transationId = transationId;
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
}
