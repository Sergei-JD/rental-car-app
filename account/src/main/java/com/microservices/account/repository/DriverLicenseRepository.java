package com.microservices.account.repository;

import com.microservices.account.entity.DriverLicense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLicenseRepository extends JpaRepository<DriverLicense, Long> {

    Page<DriverLicense> findDriverLicenseByAccountId(Long accountId, Pageable pageable);
}
