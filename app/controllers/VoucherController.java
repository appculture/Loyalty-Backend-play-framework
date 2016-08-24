package controllers;

import models.Voucher;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;
import views.html.vouchers;

import java.util.List;

public class VoucherController extends Controller {

    public Result index() {
        return list(0, "asc", "name", null);
    }

    public Result list(int page, String sortBy, String order, String filter) {
        return ok(vouchers.render(Voucher.page(page, Constants.DEFAULT_PAGE_SIZE, null, null, null), sortBy, order, filter));
    }

    private List<Voucher> getVouchers() {

        return null;
    }
}
