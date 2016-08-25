package models;

import javax.persistence.*;
import java.util.Date;

/**
 * Voucher could be used in order to spend points {@link Customer} earned in exchange for some benefits during purchase.
 * <p>
 * Created by abozic on 8/18/16.
 */
@Entity
@SequenceGenerator(name = "voucher_seq", sequenceName = "voucher_seq")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voucher_seq")
    private int voucherId;
    private String name;
    private String description;
    private String imageUrl;
    private double points;
    private boolean active;
    @Column(columnDefinition = "timestamp default now()")
    private Date creationDate;
    private Date expiryDate;

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
