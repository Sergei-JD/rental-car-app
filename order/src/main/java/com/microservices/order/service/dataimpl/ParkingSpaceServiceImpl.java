package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.CreateParkingSpaceDTO;
import com.microservices.order.dto.update.UpdateParkingSpaceDTO;
import com.microservices.order.dto.view.ViewParkingSpaceDTO;
import com.microservices.order.entity.ParkingSpace;
import com.microservices.order.mapper.ParkingSpaceMapper;
import com.microservices.order.repository.ParkingSpaceRepository;
import com.microservices.order.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.microservices.order.util.ServiceData.PARKING_SPACE_ID_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public Page<ViewParkingSpaceDTO> getAllParkingSpaces(Pageable pageable) {
        Page<ParkingSpace> pageParkingSpaces = parkingSpaceRepository.findAll(pageable);

        List<ViewParkingSpaceDTO> parkingSpaces = pageParkingSpaces.stream()
                .map(ParkingSpaceMapper::toViewParkingSpaceDTO)
                .toList();

        return new PageImpl<>(parkingSpaces);
    }

    @Override
    public Page<ViewParkingSpaceDTO> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable) {
        Page<ParkingSpace> pageParkingSpaces = parkingSpaceRepository.findParkingSpaceByOrderId(orderId, pageable);

        List<ViewParkingSpaceDTO> parkingSpaces = pageParkingSpaces.stream()
                .map(ParkingSpaceMapper::toViewParkingSpaceDTO)
                .toList();

        return new PageImpl<>(parkingSpaces);
    }

    @Override
    public ParkingSpace getParkingSpaceById(Long parkingSpaceId) {
        return parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ServiceException(String.format(PARKING_SPACE_ID_EXCEPTION_MESSAGE, parkingSpaceId)));
    }

    @Override
    @Transactional
    public Long createParkingSpace(CreateParkingSpaceDTO createParkingSpaceDTO) {
        ParkingSpace newParkingSpace = ParkingSpace.builder()
                .address(createParkingSpaceDTO.getAddress())
                .level(createParkingSpaceDTO.getLevel())
                .numberSpace(createParkingSpaceDTO.getNumberSpace())
                .build();

        ParkingSpace savedParkingSpace = parkingSpaceRepository.save(newParkingSpace);

        return savedParkingSpace.getId();
    }

    @Override
    @Transactional
    public void updateParkingSpace(Long parkingSpaceId, UpdateParkingSpaceDTO updateParkingSpaceDTO) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ServiceException(String.format(PARKING_SPACE_ID_EXCEPTION_MESSAGE, parkingSpaceId)));
        parkingSpace.setAddress(updateParkingSpaceDTO.getAddress());
        parkingSpace.setLevel(updateParkingSpaceDTO.getLevel());
        parkingSpace.setNumberSpace(updateParkingSpaceDTO.getNumberSpace());

        parkingSpaceRepository.save(parkingSpace);
    }

    @Override
    @Transactional
    public boolean deleteParkingSpace(Long parkingSpaceId) {
        parkingSpaceRepository.deleteById(parkingSpaceId);

        return parkingSpaceRepository.findById(parkingSpaceId).isEmpty();
    }
}
