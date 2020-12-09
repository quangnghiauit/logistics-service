package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cmlocation")
public class CMLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

    @Column(name = "LocCode")
    private String locCode;

    @Column(name = "LocDescription")
    private String locDescription;

    @Column(name = "WardId")
    private int districtName;

    @Column(name = "DistrictId")
    private int districtType;

    @Column(name = "ProvinceId")
    private int note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    public String getLocDescription() {
        return locDescription;
    }

    public void setLocDescription(String locDescription) {
        this.locDescription = locDescription;
    }

    public int getDistrictName() {
        return districtName;
    }

    public void setDistrictName(int districtName) {
        this.districtName = districtName;
    }

    public int getDistrictType() {
        return districtType;
    }

    public void setDistrictType(int districtType) {
        this.districtType = districtType;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
