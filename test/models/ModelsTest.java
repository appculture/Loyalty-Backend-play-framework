package models;

import org.junit.Before;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.*;

/**
 * ModelsTest setup mock database for testing purpose.
 * <p>
 * Created by abozic on 8/19/16.
 */
public class ModelsTest extends WithApplication {
//    @Before
//    public void setUp() throws Exception {
//        start(fakeApplication(inMemoryDatabase()));
//    }

    @org.junit.Test
    public void createAndRetrieveCustomer() {
        new Customer("Aca Bozic", "alex@appculture.com", "123456789").save();
        Customer alex = Customer.find.where().eq("email", "alex@appculture.com").findUnique();

        assertNotNull(alex);
        assertEquals("Aca Bozic", alex.getFullName());
        //new User("bob@gmail.com", "Bob", "secret").save();
//        User bob = User.find.where().eq("email", "bob@gmail.com").findUnique();
//        assertNotNull(bob);
//        assertEquals("Bob", bob.name);
    }
}