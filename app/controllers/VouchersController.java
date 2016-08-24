package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.vouchers;

public class VouchersController extends Controller {

    public Result index() {
        return ok(vouchers.render("Your new application is ready."));
    }
}
