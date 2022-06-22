package com.microservices.account.util;

import com.microservices.account.entity.Account;
import com.microservices.account.entity.CreditCard;
import com.microservices.account.entity.CreditCardType;
import com.microservices.account.entity.DriverLicense;
import com.microservices.account.entity.Gender;
import com.microservices.account.entity.Role;
import com.microservices.account.entity.User;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.Instant;

@UtilityClass
public class TestData {

    private final static Long TEST_FIRST_ACCOUNT_ID = 1L;
    private final static Long TEST_SECOND_ACCOUNT_ID = 2L;
    private final static Long TEST_THIRD_ACCOUNT_ID = 3L;

    private final static String TEST_FIRST_ACCOUNT_NICKNAME = "IvanavI";
    private final static String TEST_SECOND_ACCOUNT_NICKNAME = "PetrteP";
    private final static String TEST_THIRD_ACCOUNT_NICKNAME = "SergeyegreS";

    private final static String TEST_FIRST_ACCOUNT_PASSWORD = "1111";
    private final static String TEST_SECOND_ACCOUNT_PASSWORD = "2222";
    private final static String TEST_THIRD_ACCOUNT_PASSWORD = "2222";


    private final static Long TEST_FIRST_USER_ID = 1L;
    private final static Long TEST_SECOND_USER_ID = 2L;
    private final static Long TEST_THIRD_USER_ID = 3L;

    private final static String TEST_FIRST_USER_FIRSTNAME = "Ivan";
    private final static String TEST_SECOND_USER_FIRSTNAME = "Petr";
    private final static String TEST_THIRD_USER_FIRSTNAME = "Sergey";

    private final static String TEST_FIRST_USER_LASTNAME = "Ivanov";
    private final static String TEST_SECOND_USER_LASTNAME = "Petrov";
    private final static String TEST_THIRD_USER_LASTNAME = "Sergeev";

    private final static Instant TEST_FIRST_USER_DATE_OF_BIRTH = Instant.parse("1999-06-21");
    private final static Instant TEST_SECOND_USER_DATE_OF_BIRTH = Instant.parse("2001-06-21");
    private final static Instant TEST_THIRD_USER_DATE_OF_BIRTH = Instant.parse("1998-06-21");

    private final static String TEST_FIRST_USER_ID_PASSPORT_NUM = "65634234235475";
    private final static String TEST_SECOND_USER_ID_PASSPORT_NUM = "65634234235475";
    private final static String TEST_THIRD_USER_ID_PASSPORT_NUM = "65634234235475";

    private final static String TEST_FIRST_USER_EMAIL = "ivan@email.com";
    private final static String TEST_SECOND_USER_EMAIL = "petr@email.com";
    private final static String TEST_THIRD_USER_EMAIL = "sergey@email.com";

    private final static String TEST_FIRST_USER_PHONE_NUM = "+375292342345";
    private final static String TEST_SECOND_USER_PHONE_NUM = "+375332342332";
    private final static String TEST_THIRD_USER_PHONE_NUM = "+375442342352";

    private final static Gender TEST_FIRST_USER_GENDER = Gender.MALE;
    private final static Gender TEST_SECOND_USER_GENDER = Gender.MALE;
    private final static Gender TEST_THIRD_USER_GENDER = Gender.MALE;

    private final static Role TEST_FIRST_USER_ROLE = Role.ADMIN;
    private final static Role TEST_SECOND_USER_ROLE = Role.CUSTOMER;
    private final static Role TEST_THIRD_USER_ROLE = Role.CUSTOMER;


    private final static Long TEST_FIRST_CARD_ID = 1L;
    private final static Long TEST_SECOND_CARD_ID = 2L;
    private final static Long TEST_THIRD_CARD_ID = 3L;

    private final static CreditCardType TEST_FIRST_CARD_TYPE = CreditCardType.VISA;
    private final static CreditCardType TEST_SECOND_CARD_TYPE = CreditCardType.VISA;
    private final static CreditCardType TEST_THIRD_CARD_TYPE = CreditCardType.MASTERCARD;

    private final static String TEST_FIRST_CARD_NUM = "6753234223424623";
    private final static String TEST_SECOND_CARD_NUM = "6396771750148265";
    private final static String TEST_THIRD_CARD_NUM = "4312637834536454";

    private final static Instant TEST_FIRST_CARD_DATE_OF_ISSUE = Instant.parse("2015-05-19");
    private final static Instant TEST_SECOND_CARD_DATE_OF_ISSUE = Instant.parse("2020-03-08");
    private final static Instant TEST_THIRD_CARD_DATE_OF_ISSUE = Instant.parse("2016-11-24");

    private final static Instant TEST_FIRST_CARD_EXP_DATE = Instant.parse("2025-05-19");
    private final static Instant TEST_SECOND_CARD_EXP_DATE = Instant.parse("2030-03-08");
    private final static Instant TEST_THIRD_CARD_EXP_DATE = Instant.parse("2026-11-24");

    private final static String TEST_FIRST_CARD_CVV_CODE = "111";
    private final static String TEST_SECOND_CARD_CVV_CODE = "222";
    private final static String TEST_THIRD_CARD_CVV_CODE = "333";

    private final static String TEST_FIRST_CARD_OWNER = "Ivan Ivanov";
    private final static String TEST_SECOND_CARD_OWNER = "Petr Petrov";
    private final static String TEST_THIRD_CARD_OWNER = "Sergey Sergeev";

    private final static BigDecimal TEST_FIRST_CARD_BALANCE = BigDecimal.valueOf(7608);
    private final static BigDecimal TEST_SECOND_CARD_BALANCE = BigDecimal.valueOf(653);
    private final static BigDecimal TEST_THIRD_CARD_BALANCE = BigDecimal.valueOf(110367);

    private final static Long TEST_FIRST_LICENSE_ID = 1L;
    private final static Long TEST_SECOND_LICENSE_ID = 2L;
    private final static Long TEST_THIRD_LICENSE_ID = 3L;

    private final static String TEST_FIRST_LICENSE_NUM = "646324213243";
    private final static String TEST_SECOND_LICENSE_NUM = "678474325424";
    private final static String TEST_THIRD_LICENSE_NUM = "586787452341";

    private final static String TEST_FIRST_LICENSE_CATEGORY = "B";
    private final static String TEST_SECOND_LICENSE_CATEGORY = "B, C";
    private final static String TEST_THIRD_LICENSE_CATEGORY = "C";

    private final static Instant TEST_FIRST_LICENSE_DATE_OF_ISSUE = Instant.parse("2015-05-19");
    private final static Instant TEST_SECOND_LICENSE_DATE_OF_ISSUE = Instant.parse("2016-06-21");
    private final static Instant TEST_THIRD_LICENSE_DATE_OF_ISSUE = Instant.parse("2018-11-10");

    private final static Instant TEST_FIRST_LICENSE_EXP_DATE = Instant.parse("2025-05-19");
    private final static Instant TEST_SECOND_LICENSE_EXP_DATE = Instant.parse("2026-06-21");
    private final static Instant TEST_THIRD_LICENSE_EXP_DATE = Instant.parse("2028-11-10");



    public static Account initFirstAccount() {
        return Account.builder()
                .id(TEST_FIRST_ACCOUNT_ID)
                .nickName(TEST_FIRST_ACCOUNT_NICKNAME)
                .password(TEST_FIRST_ACCOUNT_PASSWORD)
                .build();
    }

    public static Account initSecondAccount() {
        return Account.builder()
                .id(TEST_SECOND_ACCOUNT_ID)
                .nickName(TEST_SECOND_ACCOUNT_NICKNAME)
                .password(TEST_SECOND_ACCOUNT_PASSWORD)
                .build();
    }

    public static Account initThirdAccount() {
        return Account.builder()
                .id(TEST_THIRD_ACCOUNT_ID)
                .nickName(TEST_THIRD_ACCOUNT_NICKNAME)
                .password(TEST_THIRD_ACCOUNT_PASSWORD)
                .build();
    }

    public static User initFirstUser() {
        return User.builder()
                .id(TEST_FIRST_USER_ID)
                .firstName(TEST_FIRST_USER_FIRSTNAME)
                .lastName(TEST_FIRST_USER_LASTNAME)
                .dateOfBirth(TEST_FIRST_USER_DATE_OF_BIRTH)
                .identityPassportNumber(TEST_FIRST_USER_ID_PASSPORT_NUM)
                .email(TEST_FIRST_USER_EMAIL)
                .phoneNumber(TEST_FIRST_USER_PHONE_NUM)
                .gender(TEST_FIRST_USER_GENDER)
                .role(TEST_FIRST_USER_ROLE)
                .account(initFirstAccount())
                .build();
    }

    public static User initSecondUser() {
        return User.builder()
                .id(TEST_SECOND_USER_ID)
                .firstName(TEST_SECOND_USER_FIRSTNAME)
                .lastName(TEST_SECOND_USER_LASTNAME)
                .dateOfBirth(TEST_SECOND_USER_DATE_OF_BIRTH)
                .identityPassportNumber(TEST_SECOND_USER_ID_PASSPORT_NUM)
                .email(TEST_SECOND_USER_EMAIL)
                .phoneNumber(TEST_SECOND_USER_PHONE_NUM)
                .gender(TEST_SECOND_USER_GENDER)
                .role(TEST_SECOND_USER_ROLE)
                .account(initSecondAccount())
                .build();
    }

    public static User initThirdUser() {
        return User.builder()
                .id(TEST_THIRD_USER_ID)
                .firstName(TEST_THIRD_USER_FIRSTNAME)
                .lastName(TEST_THIRD_USER_LASTNAME)
                .dateOfBirth(TEST_THIRD_USER_DATE_OF_BIRTH)
                .identityPassportNumber(TEST_THIRD_USER_ID_PASSPORT_NUM)
                .email(TEST_THIRD_USER_EMAIL)
                .phoneNumber(TEST_THIRD_USER_PHONE_NUM)
                .gender(TEST_THIRD_USER_GENDER)
                .role(TEST_THIRD_USER_ROLE)
                .account(initThirdAccount())
                .build();
    }

    public static CreditCard initFirstCreditCard() {
        return CreditCard.builder()
                .id(TEST_FIRST_CARD_ID)
                .creditCardType(TEST_FIRST_CARD_TYPE)
                .cardNumber(TEST_FIRST_CARD_NUM)
                .dateOfIssue(TEST_FIRST_CARD_DATE_OF_ISSUE)
                .expirationDate(TEST_FIRST_CARD_EXP_DATE)
                .cvvCode(TEST_FIRST_CARD_CVV_CODE)
                .nameCardOwner(TEST_FIRST_CARD_OWNER)
                .balance(TEST_FIRST_CARD_BALANCE)
                .account(initFirstAccount())
                .build();
    }

    public static CreditCard initSecondCreditCard() {
        return CreditCard.builder()
                .id(TEST_SECOND_CARD_ID)
                .creditCardType(TEST_SECOND_CARD_TYPE)
                .cardNumber(TEST_SECOND_CARD_NUM)
                .dateOfIssue(TEST_SECOND_CARD_DATE_OF_ISSUE)
                .expirationDate(TEST_SECOND_CARD_EXP_DATE)
                .cvvCode(TEST_SECOND_CARD_CVV_CODE)
                .nameCardOwner(TEST_SECOND_CARD_OWNER)
                .balance(TEST_SECOND_CARD_BALANCE)
                .account(initSecondAccount())
                .build();
    }

    public static CreditCard initThirdCreditCard() {
        return CreditCard.builder()
                .id(TEST_THIRD_CARD_ID)
                .creditCardType(TEST_THIRD_CARD_TYPE)
                .cardNumber(TEST_THIRD_CARD_NUM)
                .dateOfIssue(TEST_THIRD_CARD_DATE_OF_ISSUE)
                .expirationDate(TEST_THIRD_CARD_EXP_DATE)
                .cvvCode(TEST_THIRD_CARD_CVV_CODE)
                .nameCardOwner(TEST_THIRD_CARD_OWNER)
                .balance(TEST_THIRD_CARD_BALANCE)
                .account(initThirdAccount())
                .build();
    }

    public static DriverLicense initFirstDriverLicense() {
        return DriverLicense.builder()
                .id(TEST_FIRST_LICENSE_ID)
                .driverLicenseNumber(TEST_FIRST_LICENSE_NUM)
                .category(TEST_FIRST_LICENSE_CATEGORY)
                .dateOfIssue(TEST_FIRST_LICENSE_DATE_OF_ISSUE)
                .expirationDate(TEST_FIRST_LICENSE_EXP_DATE)
                .account(initFirstAccount())
                .build();
    }

    public static DriverLicense initSecondDriverLicense() {
        return DriverLicense.builder()
                .id(TEST_SECOND_LICENSE_ID)
                .driverLicenseNumber(TEST_SECOND_LICENSE_NUM)
                .category(TEST_SECOND_LICENSE_CATEGORY)
                .dateOfIssue(TEST_SECOND_LICENSE_DATE_OF_ISSUE)
                .expirationDate(TEST_SECOND_LICENSE_EXP_DATE)
                .account(initSecondAccount())
                .build();
    }

    public static DriverLicense initThirdDriverLicense() {
        return DriverLicense.builder()
                .id(TEST_THIRD_LICENSE_ID)
                .driverLicenseNumber(TEST_THIRD_LICENSE_NUM)
                .category(TEST_THIRD_LICENSE_CATEGORY)
                .dateOfIssue(TEST_THIRD_LICENSE_DATE_OF_ISSUE)
                .expirationDate(TEST_THIRD_LICENSE_EXP_DATE)
                .account(initThirdAccount())
                .build();
    }
}
