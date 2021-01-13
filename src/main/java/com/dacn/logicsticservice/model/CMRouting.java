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
    private String routCode;

    @Column(name = "RoutTransitTime")
    private long routTransitTime;

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

    public String getRoutCode() {
        return routCode;
    }

    public void setRoutCode(String locCode) {
        this.routCode = locCode;
    }

    public long getRoutTransitTime() {
        return routTransitTime;
    }

    public void setRoutTransitTime(long routTransitTime) {
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
