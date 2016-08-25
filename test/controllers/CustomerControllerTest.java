package controllers;

import models.Customer;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;

/**
 * Created by abozic on 8/23/16.
 */
public class CustomerControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder()
                .build();
    }

    @Test
    public void getCustomer() throws Exception {
        Result result = new CustomerController().getCustomer("d430a034-0bfc-484e-97cd-5505d107ab4a");
        assertEquals(OK, result.status());
//        assertEquals("application/json", result.contentType().get());
//        assertEquals("utf-8", result.charset().get());
        assertTrue(Helpers.contentAsString(result).contains("Test User 5"));
    }

    @Test
    public void getCustomerByPropertyTest() throws Exception {
        Customer customer = new CustomerController().getCustomerByProperty("email", "test.user1@sample.com");

        assertNotNull(customer);
        assertEquals("Test User 1", customer.getFullName());
    }

    /*
    @Test
  public void testIndex() {
    Result result = new HomeController().index();
    assertEquals(OK, result.status());
    assertEquals("text/html", result.contentType().get());
    assertEquals("utf-8", result.charset().get());
    assertTrue(contentAsString(result).contains("Welcome"));
  }
     */
}