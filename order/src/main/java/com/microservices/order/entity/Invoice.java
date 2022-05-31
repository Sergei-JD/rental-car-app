package com.microservices.order.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false, of =
        {"invoiceId", "amount", "startDateRent", "endDateRent",
                "rentalPeriod", "paymentDate", "invoiceStatus", "orderId"})
@Table(name = "invoice", schema = "PUBLIC")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", nullable = false)
    private Long invoiceId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "start_date_rent", nullable = false)
    private Instant startDateRent;

    @Column(name = "end_date_rent", nullable = false)
    private Instant endDateRent;

    @Column(name = "rental_period", nullable = false)
    private Integer rentalPeriod;

    @Column(name = "payment_date", nullable = false)
    private Instant paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_status", nullable = false)
    private InvoiceStatus invoiceStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order orderId;
}
