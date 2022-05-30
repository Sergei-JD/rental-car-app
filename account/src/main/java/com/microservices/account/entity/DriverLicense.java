package com.microservices.account.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false, of =
        {"driverLicenseId", "driverLicenseNumber", "category", "dateOfIssue", "expirationDate", "accountId"})
@Table(name = "driver_license", schema = "PUBLIC")
public class DriverLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_license_id", nullable = false)
    private Long driverLicenseId;

    @Column(name = "driver_license_number", nullable = false)
    private String driverLicenseNumber;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "date_of_issue", nullable = false)
    private Instant dateOfIssue;

    @Column(name = "expiration_date", nullable = false)
    private Instant expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account accountId;
}
