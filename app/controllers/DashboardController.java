package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.dashboard;
import views.html.index;

public class DashboardController extends Controller {

    @Security.Authenticated(Secured.class)
    public Result index() {
        return ok(dashboard.render(User.find.byId(request().username())));
    }
}
