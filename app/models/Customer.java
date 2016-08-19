package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

/**
 * Customer contains all profile information's related to actual client.
 * <p>
 * Created by abozic on 8/18/16.
 */
@Entity
public class Customer extends Model {

    @Id
    @GeneratedValue(generator = "uuid")
    private String customerId;
    @NotNull
    private String fullName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private double points;
    @Formats.DateTime(pattern = "dd.MM.yyyy")
    private Date birthDate;
    /**
     * User ID represent external system ID, ID might be filled during import of the data.
     */
    private String userId;
    private Date creationDate;

    public static Finder<String, Customer> find = new Finder<String, Customer>(Customer.class);

    public Customer(String fullName, String email, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void insert() {
        if (customerId == null) customerId = UUID.randomUUID().toString();
        super.insert();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
