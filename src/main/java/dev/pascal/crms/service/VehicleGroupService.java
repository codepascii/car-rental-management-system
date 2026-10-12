package dev.pascal.crms.service;

import dev.pascal.crms.dto.CreateVehicleGroupRequest;
import dev.pascal.crms.model.VehicleGroup;
import dev.pascal.crms.repository.VehicleGroupRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VehicleGroupService {

    private final VehicleGroupRepository vehicleGroupRepository;

    public VehicleGroupService(VehicleGroupRepository vehicleGroupRepository) {
        this.vehicleGroupRepository = vehicleGroupRepository;
    }

    // Retrieve all vehicle groups
    public List<VehicleGroup> getAllVehicleGroups() {
        return vehicleGroupRepository.findAll();
    }

    // Create a new vehicle group
    public VehicleGroup createVehicleGroup(CreateVehicleGroupRequest request) {

        VehicleGroup vehicleGroup = new VehicleGroup(
                request.getCode(),
                request.getName(),
                request.getDailyRate()
        );

        return vehicleGroupRepository.save(vehicleGroup);
    }

    public VehicleGroup searchVehicleGroupByCode(String code) {

        return vehicleGroupRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Vehicle group not found"
                ));
    }

    public void deleteVehicleGroupByCode(String code) {

        VehicleGroup vehicleGroup = vehicleGroupRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Vehicle group not found"
                ));

        vehicleGroupRepository.delete(vehicleGroup);
    }

}
