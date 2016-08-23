package controllers;

import models.Customer;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.customer_list;

/**
 * Created by abozic on 8/22/16.
 */
public class CustomerController extends Controller {

    /**
     * Handle default path requests, redirect to computers list
     */
    public Result index() {
        return redirect("/customer");
    }

    public Result list(int page, String sortBy, String order, String filter) {
        return ok(
                customer_list.render(
                        Customer.page(page, 10, sortBy, order, filter),
                        sortBy, order, filter
                )
        );
    }

    public Result getCustomer(String customerId){
        return ok();
    }

    public Result create() {
        return ok();
    }
}