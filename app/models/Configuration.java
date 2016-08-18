package models;

/**
 * Configuration represent system default configuration.
 * <p>
 * Created by abozic on 8/18/16.
 */
public class Configuration {

    private String currency;
    private double bonusPointsRation;
    private boolean confirmPurchase;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBonusPointsRation() {
        return bonusPointsRation;
    }

    public void setBonusPointsRation(double bonusPointsRation) {
        this.bonusPointsRation = bonusPointsRation;
    }

    public boolean isConfirmPurchase() {
        return confirmPurchase;
    }

    public void setConfirmPurchase(boolean confirmPurchase) {
        this.confirmPurchase = confirmPurchase;
    }
}
