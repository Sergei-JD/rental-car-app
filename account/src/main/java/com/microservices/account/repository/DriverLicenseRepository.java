package com.microservices.account.repository;

import com.microservices.account.entity.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long> {

    Optional<DriverLicense> findDriverLicenseByAccountId(Long accountId);
}
