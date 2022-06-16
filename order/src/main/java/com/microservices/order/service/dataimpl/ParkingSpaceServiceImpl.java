package com.microservices.order.service.dataimpl;

import com.microservices.order.entity.ParkingSpace;
import com.microservices.order.repository.ParkingSpaceRepository;
import com.microservices.order.service.ParkingSpaceService;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.microservices.order.util.ServiceData.PARKING_SPACE_DELETE_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.PARKING_SPACE_ID_EXCEPTION_MESSAGE;
import static com.microservices.order.util.ServiceData.PARKING_SPACE_UPDATE_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
public class ParkingSpaceServiceImpl implements ParkingSpaceService {

    private final ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public Page<ParkingSpace> getAllParkingSpaces(Pageable pageable) {
        return parkingSpaceRepository.findAll(pageable);
    }

    @Override
    public Page<ParkingSpace> getAllParkingSpaceByOrderId(Long orderId, Pageable pageable) {
        return parkingSpaceRepository.findParkingSpaceByOrderId(orderId, pageable);
    }

    @Override
    public ParkingSpace getParkingSpaceById(long parkingSpaceId) {
        return parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ServiceException(String.format(PARKING_SPACE_ID_EXCEPTION_MESSAGE, parkingSpaceId)));
    }

    @Override
    @Transactional
    public ParkingSpace createParkingSpace(ParkingSpace parkingSpace) {
        return parkingSpaceRepository.save(parkingSpace);
    }

    @Override
    @Transactional
    public ParkingSpace updateParkingSpace(ParkingSpace parkingSpace) {
        ParkingSpace maybeParkingSpace = parkingSpaceRepository.findById(parkingSpace.getId())
                .orElseThrow(() -> new ServiceException(PARKING_SPACE_UPDATE_EXCEPTION_MESSAGE));
        return parkingSpaceRepository.save(maybeParkingSpace);
    }

    @Override
    @Transactional
    public boolean deleteParkingSpace(long parkingSpaceId) {
        ParkingSpace maybeParkingSpace = parkingSpaceRepository.findById(parkingSpaceId)
                .orElseThrow(() -> new ServiceException(String.format(PARKING_SPACE_DELETE_EXCEPTION_MESSAGE, parkingSpaceId)));
        parkingSpaceRepository.deleteById(maybeParkingSpace.getId());
        return parkingSpaceRepository.findById(parkingSpaceId).isEmpty();
    }
}
