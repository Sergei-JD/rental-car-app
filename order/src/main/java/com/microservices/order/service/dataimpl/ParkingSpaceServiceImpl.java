package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.request.ParkingSpaceRequestDTO;
import com.microservices.order.dto.request.ParkingSpaceUpdateRequestDTO;
import com.microservices.order.dto.response.ParkingSpaceResponseDTO;
import com.microservices.order.entity.ParkingSpace;
import com.microservices.order.mapper.request.ParkingSpaceRequestDTOToParkingSpaceMapper;
import com.microservices.order.mapper.request.ParkingSpaceUpdateRequestDTOToParkingSpaceMapper;
import com.microservices.order.mapper.response.ParkingSpaceToParkingSpaceResponseDTOMapper;
import com.microservices.order.repository.ParkingSpaceRepository;
import com.microservices.order.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;
    private final ParkingSpaceRequestDTOToParkingSpaceMapper parkingSpaceRequestDTOToParkingSpaceMapper;
    private final ParkingSpaceToParkingSpaceResponseDTOMapper parkingSpaceToParkingSpaceResponseDTOMapper;
    private final ParkingSpaceUpdateRequestDTOToParkingSpaceMapper parkingSpaceUpdateRequestDTOToParkingSpaceMapper;

    @Override
    public Page<ParkingSpaceResponseDTO> getAllParkingSpaces(Pageable pageable) {
        Page<ParkingSpace> pageParkingSpaces = parkingSpaceRepository.findAll(pageable);

        List<ParkingSpaceResponseDTO> parkingSpaces = pageParkingSpaces.stream()
                .map(parkingSpaceToParkingSpaceResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(parkingSpaces);
    }

    @Override
    public Page<ParkingSpaceResponseDTO> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable) {
        Page<ParkingSpace> pageParkingSpaces = parkingSpaceRepository.findParkingSpaceByOrderId(orderId, pageable);

        List<ParkingSpaceResponseDTO> parkingSpaces = pageParkingSpaces.stream()
                .map(parkingSpaceToParkingSpaceResponseDTOMapper::convert)
                .toList();

        return new PageImpl<>(parkingSpaces);
    }

    @Override
    public Optional<ParkingSpaceResponseDTO> getParkingSpaceById(long parkingSpaceId) {
        ParkingSpaceResponseDTO parkingSpaceResponseDTO = null;

        Optional<ParkingSpace> parkingSpace = parkingSpaceRepository.findById(parkingSpaceId);
        if (parkingSpace.isPresent()) {
            parkingSpaceResponseDTO = parkingSpaceToParkingSpaceResponseDTOMapper.convert(parkingSpace.get());
        }

        return Optional.ofNullable(parkingSpaceResponseDTO);
    }

    @Override
    public ParkingSpaceResponseDTO createParkingSpace(ParkingSpaceRequestDTO parkingSpaceRequestDTO) {
        ParkingSpace newParkingSpace = parkingSpaceRequestDTOToParkingSpaceMapper.convert(parkingSpaceRequestDTO);
        ParkingSpace saveParkingSpace = parkingSpaceRepository.save(Objects.requireNonNull(newParkingSpace));

        return parkingSpaceToParkingSpaceResponseDTOMapper.convert(saveParkingSpace);
    }

    @Override
    public ParkingSpaceResponseDTO updateParkingSpace(ParkingSpaceUpdateRequestDTO parkingSpaceUpdateRequestDTO) {
        parkingSpaceRepository.findById(parkingSpaceUpdateRequestDTO.getParkingSpaceId())
                .orElseThrow(() -> new ServiceException("Failed to update parking space no such parking space"));

        ParkingSpace parkingSpace = parkingSpaceUpdateRequestDTOToParkingSpaceMapper.convert(parkingSpaceUpdateRequestDTO);
        ParkingSpace updateParkingSpace = parkingSpaceRepository.save(Objects.requireNonNull(parkingSpace));

        return parkingSpaceToParkingSpaceResponseDTOMapper.convert(updateParkingSpace);
    }

    @Override
    public boolean deleteParkingSpace(long parkingSpaceId) {
        parkingSpaceRepository.deleteById(parkingSpaceId);

        return parkingSpaceRepository.findById(parkingSpaceId).isEmpty();
    }
}
