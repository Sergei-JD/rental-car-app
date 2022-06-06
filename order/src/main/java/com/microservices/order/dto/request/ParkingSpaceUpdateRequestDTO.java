package com.microservices.order.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceUpdateRequestDTO {

    @NotEmpty(message = "'Parking space id' should not be empty")
    @Positive(message = "'Parking space id' should be positive number")
    private Long parkingSpaceId;

    @NotEmpty(message = "'Address' should not be empty")
    @Size(min = 2, max = 256, message = "'Address' should be between 2 and 256 characters")
    private String address;

    @NotEmpty(message = "'Level' should not be empty")
    @Size(min = 1, message = "'Level' should be at least one character")
    private String level;

    @NotEmpty(message = "'Number space' should not be empty")
    @Size(min = 1, message = "'Number space' should be at least one character")
    private String numberSpace;
}
