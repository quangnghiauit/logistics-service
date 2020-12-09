package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "rulrate")
public class RulRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

    @Column(name = "RoutID")
    private int routID;

    @Column(name = "ContID")
    private int contID;

    @Column(name = "CompanyID")
    private int companyID;

    @Column(name = "ValidDate")
    private String validDate;

    @Column(name = "ApplyDate")
    private String applyDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoutID() {
        return routID;
    }

    public void setRoutID(int routID) {
        this.routID = routID;
    }

    public int getContID() {
        return contID;
    }

    public void setContID(int contID) {
        this.contID = contID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }
}
