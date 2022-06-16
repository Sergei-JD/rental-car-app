package com.microservices.account.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceData {

    public static final String USER_ID_EXCEPTION_MESSAGE = "Unable to find 'user' with 'id': %d";
    public static final String USER_EMAIL_EXCEPTION_MESSAGE = "Unable to find 'user' with 'email': %s";
    public static final String USER_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'user' no such 'user'";
    public static final String USER_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'user' with 'id': %d";

    public static final String ACCOUNT_ID_EXCEPTION_MESSAGE = "Unable to find 'account' with 'id': %d";
    public static final String ACCOUNT_NICKNAME_EXCEPTION_MESSAGE = "Unable to find 'account' with 'nickname': %s";
    public static final String ACCOUNT_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'account' no such account'";
    public static final String ACCOUNT_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'account' with 'id': %d";

    public static final String CREDIT_CARD_ID_EXCEPTION_MESSAGE = "Unable to find 'credit card' with 'id': %d";
    public static final String CREDIT_CARD_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'user' no such 'user'";
    public static final String CREDIT_CARD_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'user' with 'id': %d";

    public static final String DRIVER_LICENSE_ID_EXCEPTION_MESSAGE = "Unable to find 'driver license' with 'id': %d";
    public static final String DRIVER_LICENSE_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'driver license' no such 'driver license'";
    public static final String DRIVER_LICENSE_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'driver license' with 'id': %d";
}
