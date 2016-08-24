package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.vouchers;

public class SettingsController extends Controller {

    public Result index() {
        return ok(vouchers.render("Your new application is ready."));
    }
}
