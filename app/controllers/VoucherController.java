package controllers;

import models.User;
import models.Voucher;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.Constants;
import views.html.voucher.edit;
import views.html.voucher.summary;

import javax.inject.Inject;
import java.util.List;

public class VoucherController extends Controller {

    private FormFactory formFactory;

    @Inject
    public VoucherController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    @Security.Authenticated(Secured.class)
    public Result index() {
        return list(0, "asc", "name", null);
    }

    @Security.Authenticated(Secured.class)
    public Result list(int page, String sortBy, String order, String filter) {
        return ok(summary.render(Voucher.page(page, Constants.DEFAULT_PAGE_SIZE, null, null, null), sortBy, order, filter, User.find.byId(request().username())));
    }

    public Result newVoucher() {
        return ok(edit.render(formFactory.form(Voucher.class).fill(new Voucher())));
//        userForm.bindFromRequest().get();
//        return ok(edit.render(new Voucher()));
    }

    public Result edit(int voucherId) {
        Voucher voucher = Voucher.find.byId(voucherId);
        if (voucher == null) return badRequest("Voucher not found");

        return ok(edit.render(formFactory.form(Voucher.class).fill(voucher)));
    }

    public Result save() {
        Form<Voucher> filledForm = formFactory.form(Voucher.class).bindFromRequest();

        Voucher voucher = filledForm.get();
        Logger.info("Voucher to save:" + Json.toJson(voucher));
        if (filledForm.hasErrors()) {
            return badRequest(edit.render(filledForm));
        } else {
            filledForm.get().save();
            return index();
        }
    }

    private List<Voucher> getVouchers() {
        return Voucher.find.all();
    }
}
