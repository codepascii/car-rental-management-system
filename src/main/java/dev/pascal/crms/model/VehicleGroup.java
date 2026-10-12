package dev.pascal.crms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "vehicle_groups")
public class VehicleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(name = "daily_rate", nullable = false)
    private BigDecimal dailyRate;

    protected VehicleGroup() {
    }

    public VehicleGroup(String code, String name, BigDecimal dailyRate) {
        this.code = code;
        this.name = name;
        this.dailyRate = dailyRate;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }
}
