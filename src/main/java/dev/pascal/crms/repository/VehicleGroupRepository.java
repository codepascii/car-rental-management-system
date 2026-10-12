package dev.pascal.crms.repository;

import dev.pascal.crms.model.VehicleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleGroupRepository extends JpaRepository<VehicleGroup, Long> {

    Optional<VehicleGroup> findByCode(String code);

}
