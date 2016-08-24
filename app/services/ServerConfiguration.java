package services;

import models.Configuration;

import javax.inject.Singleton;

/**
 * Created by abozic on 8/24/16.
 */
@Singleton
public class ServerConfiguration {

    private Configuration configuration;

    public Configuration getConfiguration() {
        if (configuration == null) {
            configuration = loadConfigFromDatabase();
        } else {
            configuration.refresh();
        }
        return configuration;
    }

    private Configuration loadConfigFromDatabase() {
        Configuration configuration = Configuration.find.byId(1);
        if (configuration == null) {
            configuration = createNewConfig();
        }
        return configuration;
    }

    private Configuration createNewConfig() {
        Configuration configuration = new Configuration();
        configuration.setBonusPointsRatio(100);
        configuration.setCurrency("CHF");
        configuration.setConfirmPurchase(false);
        configuration.save();
        return configuration;
    }
}
