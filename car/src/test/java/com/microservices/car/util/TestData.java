package com.microservices.car.util;

import com.microservices.car.entity.CarCatalog;
import com.microservices.car.entity.CarStatus;
import com.microservices.car.entity.CarType;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class TestData {

    private final static Long TEST_FIRST_CAR_ID = 1L;
    private final static Long TEST_SECOND_CAR_ID = 2L;
    private final static Long TEST_THIRD_CAR_ID = 3L;

    private final static String TEST_FIRST_CAR_REG_NUM = "AA-1111";
    private final static String TEST_SECOND_CAR_REG_NUM = "BB-2222";
    private final static String TEST_THIRD_CAR_REG_NUM = "CC-3333";

    private final static CarType TEST_FIRST_CAR_TYPE = CarType.COUPE;
    private final static CarType TEST_SECOND_CAR_TYPE = CarType.COUPE;
    private final static CarType TEST_THIRD_CAR_TYPE = CarType.SUV;

    private final static String TEST_FIRST_CAR_YEAR = "2002";
    private final static String TEST_SECOND_CAR_YEAR = "2000";
    private final static String TEST_THIRD_CAR_YEAR = "2002";

    private final static String TEST_FIRST_CAR_MAKE = "LADA";
    private final static String TEST_SECOND_CAR_MAKE = "LADA";
    private final static String TEST_THIRD_CAR_MAKE = "SKODA";

    private final static String TEST_FIRST_CAR_MODEL = "VESTA";
    private final static String TEST_SECOND_CAR_MODEL = "VESTA";
    private final static String TEST_THIRD_CAR_MODEL = "RAPID";

    private final static String TEST_FIRST_CAR_COLOUR = "WHITE";
    private final static String TEST_SECOND_CAR_COLOUR = "WHITE";
    private final static String TEST_THIRD_CAR_COLOUR = "BLACK";

    private final static BigDecimal TEST_FIRST_CAR_PRICE = BigDecimal.valueOf(11.11);
    private final static BigDecimal TEST_SECOND_CAR_PRICE = BigDecimal.valueOf(11.11);
    private final static BigDecimal TEST_THIRD_CAR_PRICE = BigDecimal.valueOf(22.22);

    private final static CarStatus TEST_FIRST_CAR_STATUS = CarStatus.READY;
    private final static CarStatus TEST_SECOND_CAR_STATUS = CarStatus.READY;
    private final static CarStatus TEST_THIRD_CAR_STATUS = CarStatus.WASH;

    public static CarCatalog initFirstCar() {
        return CarCatalog.builder()
                .id(TEST_FIRST_CAR_ID)
                .registrationNumber(TEST_FIRST_CAR_REG_NUM)
                .carType(TEST_FIRST_CAR_TYPE)
                .yearOfManufacture(TEST_FIRST_CAR_YEAR)
                .make(TEST_FIRST_CAR_MAKE)
                .model(TEST_FIRST_CAR_MODEL)
                .colour(TEST_FIRST_CAR_COLOUR)
                .price(TEST_FIRST_CAR_PRICE)
                .carStatus(TEST_FIRST_CAR_STATUS)
                .build();
    }

    public static CarCatalog initSecondCar() {
        return CarCatalog.builder()
                .id(TEST_SECOND_CAR_ID)
                .registrationNumber(TEST_SECOND_CAR_REG_NUM)
                .carType(TEST_SECOND_CAR_TYPE)
                .yearOfManufacture(TEST_SECOND_CAR_YEAR)
                .make(TEST_SECOND_CAR_MAKE)
                .model(TEST_SECOND_CAR_MODEL)
                .colour(TEST_SECOND_CAR_COLOUR)
                .price(TEST_SECOND_CAR_PRICE)
                .carStatus(TEST_SECOND_CAR_STATUS)
                .build();
    }

    public static CarCatalog initThirdCar() {
        return CarCatalog.builder()
                .id(TEST_THIRD_CAR_ID)
                .registrationNumber(TEST_THIRD_CAR_REG_NUM)
                .carType(TEST_THIRD_CAR_TYPE)
                .yearOfManufacture(TEST_THIRD_CAR_YEAR)
                .make(TEST_THIRD_CAR_MAKE)
                .model(TEST_THIRD_CAR_MODEL)
                .colour(TEST_THIRD_CAR_COLOUR)
                .price(TEST_THIRD_CAR_PRICE)
                .carStatus(TEST_THIRD_CAR_STATUS)
                .build();
    }
}
