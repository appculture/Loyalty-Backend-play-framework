package models;

import com.avaje.ebean.annotation.EnumMapping;

/**
 * Type of transaction represent the way how user earned or spent his points.
 * <p>
 * Created by abozic on 8/18/16.
 */
@EnumMapping(nameValuePairs = "PURCHASE=PURCHASE, INVITE=INVITE, REDEEM=REDEEM")
public enum TransactionType {

    PURCHASE,
    INVITE,
    REDEEM
}
