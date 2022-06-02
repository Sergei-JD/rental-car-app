package com.microservices.order.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Positive;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ParkingSpaceResponseFullDTO extends ParkingSpaceRequestDTO{

    @Positive(message = "'Parking space id' should be positive number")
    private Long parkingSpaceId;
}
