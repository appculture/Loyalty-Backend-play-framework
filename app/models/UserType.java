package models;

import com.avaje.ebean.annotation.EnumMapping;

/**
 * System User type.
 * Created by abozic on 8/19/16.
 */
@EnumMapping(nameValuePairs = "ADMIN=ADMIN, CUSTOMER=CUSTOMER")
public enum UserType {

    ADMIN,
    CUSTOMER
}
