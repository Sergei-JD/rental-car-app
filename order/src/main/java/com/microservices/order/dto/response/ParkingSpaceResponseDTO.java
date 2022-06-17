package com.microservices.order.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceResponseDTO {

    private Long id;

    private String address;

    private String level;

    private String numberSpace;
}
