package com.microservices.order.service.dataimpl;

import com.microservices.order.dto.create.ParkingSpaceCreateDTO;
import com.microservices.order.dto.update.ParkingSpaceUpdateDTO;
import com.microservices.order.dto.view.ParkingSpaceViewDTO;
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
    public Page<ParkingSpaceViewDTO> getAllParkingSpaces(Pageable pageable) {
        Page<ParkingSpace> pageParkingSpaces = parkingSpaceRepository.findAll(pageable);

        List<ParkingSpaceViewDTO> parkingSpaces = pageParkingSpaces.stream()
                .map(ParkingSpaceMapper::toParkingSpaceViewDTO)
                .toList();

        return new PageImpl<>(parkingSpaces);
    }

    @Override
    public Page<ParkingSpaceViewDTO> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable) {
        Page<ParkingSpace> pageParkingSpaces = parkingSpaceRepository.findParkingSpaceByOrderId(orderId, pageable);

        List<ParkingSpaceViewDTO> parkingSpaces = pageParkingSpaces.stream()
                .map(ParkingSpaceMapper::toParkingSpaceViewDTO)
                .toList();

        return new PageImpl<>(parkingSpaces);
    }

    @Override
    public ParkingSpaceViewDTO getParkingSpaceById(Long parkingSpaceId) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ServiceException(String.format(PARKING_SPACE_ID_EXCEPTION_MESSAGE, parkingSpaceId)));

        return ParkingSpaceMapper.toParkingSpaceViewDTO(parkingSpace);
    }

    @Override
    @Transactional
    public ParkingSpaceCreateDTO createParkingSpace(ParkingSpaceCreateDTO parkingSpaceCreateDTO) {
        ParkingSpace newParkingSpace = ParkingSpace.builder()
                .address(parkingSpaceCreateDTO.getAddress())
                .level(parkingSpaceCreateDTO.getLevel())
                .numberSpace(parkingSpaceCreateDTO.getNumberSpace())
                .build();

        return ParkingSpaceMapper.toParkingSpaceCreateDTO(parkingSpaceRepository.save(newParkingSpace));
    }

    @Override
    @Transactional
    public ParkingSpaceUpdateDTO updateParkingSpace(Long parkingSpaceId, ParkingSpaceUpdateDTO parkingSpaceUpdateDTO) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ServiceException(String.format(PARKING_SPACE_ID_EXCEPTION_MESSAGE, parkingSpaceId)));
        parkingSpace.setAddress(parkingSpaceUpdateDTO.getAddress());
        parkingSpace.setLevel(parkingSpaceUpdateDTO.getLevel());
        parkingSpace.setNumberSpace(parkingSpaceUpdateDTO.getNumberSpace());

        parkingSpaceRepository.save(parkingSpace);

        return ParkingSpaceMapper.toParkingSpaceUpdateDTO(parkingSpace);
    }

    @Override
    @Transactional
    public boolean deleteParkingSpace(Long parkingSpaceId) {
        parkingSpaceRepository.deleteById(parkingSpaceId);

        return parkingSpaceRepository.findById(parkingSpaceId).isEmpty();
    }
}
