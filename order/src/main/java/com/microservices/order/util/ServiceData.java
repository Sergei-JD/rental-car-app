package com.microservices.order.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceData {

    public static final String INVOICE_ID_EXCEPTION_MESSAGE = "Unable to find 'invoice' with 'id': %d";
    public static final String INVOICE_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'invoice' no such 'invoice'";
    public static final String INVOICE_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'invoice' with 'id': %d";

    public static final String ORDER_ID_EXCEPTION_MESSAGE = "Unable to find 'order' with 'id': %d";
    public static final String ORDER_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'order' no such 'order'";
    public static final String ORDER_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'order' with 'id': %d";

    public static final String PARKING_SPACE_ID_EXCEPTION_MESSAGE = "Unable to find 'parking space' with 'id': %d";
    public static final String PARKING_SPACE_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'parking space' no such 'parking space'";
    public static final String PARKING_SPACE_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'parking space' with 'id': %d";

    public static final String RESERVATION_ID_EXCEPTION_MESSAGE = "Unable to find 'reservation' with 'id': %d";
    public static final String RESERVATION_UPDATE_EXCEPTION_MESSAGE = "Failed to update 'reservation' no such 'reservation'";
    public static final String RESERVATION_DELETE_EXCEPTION_MESSAGE = "Failed to delete 'reservation' with 'id': %d";
}
