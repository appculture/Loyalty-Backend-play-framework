package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Customer;

import models.User;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import utils.Constants;
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
    @Security.Authenticated(Secured.class)
    public Result index() {
        return redirect("/customer");
    }

    @Security.Authenticated(Secured.class)
    public Result list(int page, String sortBy, String order, String filter) {
        return ok(
                customer_list.render(
                        Customer.page(page, Constants.DEFAULT_PAGE_SIZE, sortBy, order, filter),
                        sortBy, order, filter, User.find.byId(request().username()
                )
        ));
    }

    public Result getCustomer(String customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) return badRequest("Customer not found");

        JsonNode result = Json.toJson(customer);
        Logger.info("Customer found: " + result);
        return ok(result);
    }

    public Customer getCustomerByProperty(String propertyName, Object value) {
        return Customer.find.where().eq(propertyName, value).findUnique();
    }

    private Customer getCustomerById(String customerId) {
        if (Strings.isNullOrEmpty(customerId)) return null;
        Logger.info("Requested customerID: " + customerId);

        return Customer.find.byId(customerId);
    }

    public Result create() {
        return ok();
    }
}