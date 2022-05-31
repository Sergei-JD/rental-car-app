package com.microservices.account.repository;

import com.microservices.account.entity.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long> {
}
