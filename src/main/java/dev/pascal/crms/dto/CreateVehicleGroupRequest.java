package dev.pascal.crms.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateVehicleGroupRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private BigDecimal dailyRate;

    public CreateVehicleGroupRequest() {
    }

    public CreateVehicleGroupRequest(
            String code,
            String name,
            BigDecimal dailyRate
    ) {
        this.code = code;
        this.name = name;
        this.dailyRate = dailyRate;
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

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }
}
