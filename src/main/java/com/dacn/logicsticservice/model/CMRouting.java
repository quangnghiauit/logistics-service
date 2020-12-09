package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cmrouting")
public class CMRouting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private String id;

    @Column(name = "RoutCode")
    private String locCode;

    @Column(name = "RoutTransitTime")
    private float routTransitTime;

    @Column(name = "RoutFirstStep")
    private int routFirstStep;

    @Column(name = "RoutLastStep")
    private int routLastStep;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
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

}
