package controllers;

import models.User;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.login;

import javax.inject.Inject;

public class LoginController extends Controller {

    private FormFactory formFactory;

    @Inject
    public LoginController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result login() {
        return ok(login.render(formFactory.form(Login.class)));

    }

    public Result logout() {
        session().clear();
        flash("success", "You've been logged out");
        return redirect(
                routes.LoginController.login()
        );
    }

    public Result authenticate() {
        Form<Login> loginForm = formFactory.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            Logger.debug("Login Controller:there are errors" + loginForm.errors().toString());
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("username", loginForm.get().email);
            return redirect(routes.DashboardController.index());
        }
    }

    public static class Login {

        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String validate() {

            if (User.authenticate(email, password) == null) {
                return "Invalid user or password";
            }
            return null;
        }

    }


}
