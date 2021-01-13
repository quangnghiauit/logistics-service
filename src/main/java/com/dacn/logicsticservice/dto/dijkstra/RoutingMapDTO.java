package com.dacn.logicsticservice.dto.dijkstra;

import com.dacn.logicsticservice.model.CMRouting;

public class RoutingMapDTO {

    private String id;
    private String routCode;
    private float routTransitTime;
    private int routFirstStep;
    private int routLastStep;
    private long totalAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoutCode() {
        return routCode;
    }

    public void setRoutCode(String routCode) {
        this.routCode = routCode;
    }

    public float getRoutTransitTime() {
        return routTransitTime;
    }

    public void setRoutTransitTime(float routTransitTime) {
        this.routTransitTime = routTransitTime;
    }

    public int getRoutFirstStep() {
        return routFirstStep;
    }

    public void setRoutFirstStep(int routFirstStep) {
        this.routFirstStep = routFirstStep;
    }

    public int getRoutLastStep() {
        return routLastStep;
    }

    public void setRoutLastStep(int routLastStep) {
        this.routLastStep = routLastStep;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void doMappingToEntity(CMRouting entity) {
        this.id = entity.getId();
        this.routCode = entity.getRoutCode();
        this.routTransitTime = entity.getRoutTransitTime();
        this.routFirstStep = entity.getRoutFirstStep();
        this.routLastStep = entity.getRoutLastStep();
    }
}
