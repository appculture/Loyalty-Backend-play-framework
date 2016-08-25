package controllers;

import models.Configuration;
import models.User;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import play.mvc.Security;
import services.ServerConfiguration;
import views.html.settings_page;

import javax.inject.Inject;

public class SettingsController extends Controller {

    private FormFactory formFactory;

    @Inject
    public SettingsController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    @Inject
    ServerConfiguration serverConfiguration;

    @Security.Authenticated(Secured.class)
    public Result index() {

        Configuration configuration = serverConfiguration.getConfiguration();

        Form<Configuration> settingsForm = formFactory.form(Configuration.class).bindFromRequest().fill(configuration);

        return ok(settings_page.render(User.find.byId(request().username()), settingsForm));

    }

    @Security.Authenticated(Secured.class)
    public Result submitConfiguration() {
        Form<Configuration> settingsForm = formFactory.form(Configuration.class).bindFromRequest();
        //String confirmPurchase = formFactory.form(Configuration.class).field("currency").value();

        //Logger.debug("confirmPurchase submit:" + confirmPurchase);
        settingsForm.get().update();
        //flash("success", "Configuration has been ");

        return ok(settings_page.render(User.find.byId(request().username()), settingsForm));
    }
}
