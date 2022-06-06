package com.microservices.order.dto.request;

import com.microservices.order.entity.Order;
import com.microservices.order.entity.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Instant;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationUpdateRequestDTO {

    @NotEmpty(message = "'Reservation id' should not be empty")
    @Positive(message = "'Reservation id' should be positive number")
    private Long reservationId;

    @NotEmpty(message = "'Order id' should not be empty")
    @Positive(message = "'Order id' should be positive number")
    private Order orderId;

    @NotEmpty(message = "'Car catalog id' should not be empty")
    @Positive(message = "'Car catalog id' should be positive number")
    private Long carCatalogId;

    @NotEmpty(message = "'Pick up date-time' should not be empty")
    private Instant pickUpDateTime;

    @NotEmpty(message = "'Drop off date-time' should not be empty")
    private Instant dropOffDateTime;

    @NotEmpty(message = "'Reservation status' should not be empty")
    @Size(min = 2, max = 64, message = "'Reservation status' should be 'FREE' or 'BOOKED'")
    private ReservationStatus reservationStatus;
}
