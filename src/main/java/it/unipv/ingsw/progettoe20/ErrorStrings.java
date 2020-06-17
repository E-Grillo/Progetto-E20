package it.unipv.ingsw.progettoe20;

import it.unipv.ingsw.progettoe20.server.database.DBConstants;

/**
 * Definizione delle stringhe di errore.
 */
public class ErrorStrings {
    public static final String SERVER_START_FAIL = "Can't start server!";

    public static final String ID_NOT_FOUND = "Can't find ticket in database!";

    public  static final String LEVEL_NOT_FOUND = "Can't find level in database!";
    public static final String WRONG_LEVEL_NAME_LENGTH = "Level's name must be " + DBConstants.LEVEL_NAME_LENGTH +
            " long!";

    public  static final String PRICE_NOT_FOUND = "Can't find price in database!";
}
