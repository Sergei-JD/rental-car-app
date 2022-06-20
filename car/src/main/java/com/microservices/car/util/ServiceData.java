package com.microservices.car.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceData {

    public static final String CAR_CATALOG_ID_EXCEPTION_MESSAGE = "Unable to find 'car' with 'id': %d";
    public static final String CAR_CATALOG_REGISTRATION_NUMBER_EXCEPTION_MESSAGE = "Unable to find 'car' with 'registration number': %s";
}
