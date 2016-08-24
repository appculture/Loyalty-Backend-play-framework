package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Configuration represent system default configuration.
 * <p>
 * Created by abozic on 8/18/16.
 */
@Entity
public class Configuration extends Model {

    @Id
    private int id = 1;
    private String currency;
    private double bonusPointsRatio;
    private boolean confirmPurchase;

    public static Model.Finder<Integer, Configuration> find = new Model.Finder<>(Configuration.class);

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBonusPointsRatio() {
        return bonusPointsRatio;
    }

    public void setBonusPointsRatio(double bonusPointsRatio) {
        this.bonusPointsRatio = bonusPointsRatio;
    }

    public boolean isConfirmPurchase() {
        return confirmPurchase;
    }

    public void setConfirmPurchase(boolean confirmPurchase) {
        this.confirmPurchase = confirmPurchase;
    }
}
