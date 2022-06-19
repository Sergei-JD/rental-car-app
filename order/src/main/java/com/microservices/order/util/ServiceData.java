package com.microservices.order.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceData {

    public static final String INVOICE_ID_EXCEPTION_MESSAGE = "Unable to find 'invoice' with 'id': %d";

    public static final String ORDER_ID_EXCEPTION_MESSAGE = "Unable to find 'order' with 'id': %d";

    public static final String PARKING_SPACE_ID_EXCEPTION_MESSAGE = "Unable to find 'parking space' with 'id': %d";

    public static final String RESERVATION_ID_EXCEPTION_MESSAGE = "Unable to find 'reservation' with 'id': %d";
}
