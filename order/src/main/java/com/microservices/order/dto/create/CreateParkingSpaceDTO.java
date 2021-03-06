package com.microservices.order.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreateParkingSpaceDTO {

    @NotEmpty(message = "'Address' should not be empty")
    @Size(min = 2, max = 256, message = "'Address' should be between 2 and 256 characters")
    private String address;

    @NotEmpty(message = "'Level' should not be empty")
    @Size(min = 1, message = "'Level' should be at least one character")
    private String level;

    @NotEmpty(message = "'Number space' should not be empty")
    @Size(min = 1, message = "'Number space' should be at least one character")
    private String numberSpace;

    @NotEmpty(message = "'Order id' should not be empty")
    private Long orderId;
}
