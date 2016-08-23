package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Customer;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Strings;
import views.html.customer_list;

/**
 * Customer operations controller.
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

    public Result getCustomer(String customerId) {
        if (Strings.isNullOrEmpty(customerId)) return badRequest("Customer ID not valid");
        Logger.info("Requested customerID: " + customerId);

        Customer customer = Customer.find.byId(customerId);
        if (customer == null) return badRequest("No customer found");

        JsonNode result = Json.toJson(customer);
        Logger.info("Customer found: " + result);

        return ok(result);
    }

    public Result create() {
        return ok();
    }
}