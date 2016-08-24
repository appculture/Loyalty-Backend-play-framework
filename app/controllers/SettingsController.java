package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.settings;

public class SettingsController extends Controller {

    public Result index() {
        return ok(settings.render("Your new application is ready."));
    }
}
