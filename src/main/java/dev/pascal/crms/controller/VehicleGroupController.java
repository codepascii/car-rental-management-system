package dev.pascal.crms.controller;

import dev.pascal.crms.dto.CreateVehicleGroupRequest;
import dev.pascal.crms.model.VehicleGroup;
import dev.pascal.crms.service.VehicleGroupService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-groups")
public class VehicleGroupController {

    private final VehicleGroupService vehicleGroupService;

    public VehicleGroupController(VehicleGroupService vehicleGroupService) {
        this.vehicleGroupService = vehicleGroupService;
    }

    @GetMapping
    public List<VehicleGroup> getAllVehicleGroups() {
        return vehicleGroupService.getAllVehicleGroups();
    }

    @GetMapping("/search")
    public VehicleGroup searchVehicleGroupByCode(@RequestParam String code) {

        return vehicleGroupService.searchVehicleGroupByCode(code);
    }

    @PostMapping
    public ResponseEntity<VehicleGroup> createVehicleGroup(
            @Valid @RequestBody CreateVehicleGroupRequest request
    ) {
        VehicleGroup createdVehicleGroup =
                vehicleGroupService.createVehicleGroup(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdVehicleGroup);
    }

    @DeleteMapping("/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicleGroupByCode(@PathVariable String code) {

        vehicleGroupService.deleteVehicleGroupByCode(code);
    }
}
