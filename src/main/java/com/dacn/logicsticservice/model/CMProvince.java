package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cmprovince")
public class CMProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ProvinceId")
    private String provinceId;

    @Column(name = "NationId")
    private String nationId;

    @Column(name = "ProvinceCode")
    private String provinceCode;

    @Column(name = "ProvinceName")
    private String provinceName;

    @Column(name = "ProvinceType")
    private String provinceType;

    @Column(name = "Note")
    private String note;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "ModifiedDate")
    private String modifiedDate;

    @Column(name = "IsDeleted")
    private int isDeleted;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "AuthStatus")
    private String authStatus;

    @Column(name = "ApprovedDate")
    private String approvedDate;

    @Column(name = "ApprovedBy")
    private String approvedBy;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceType() {
        return provinceType;
    }

    public void setProvinceType(String provinceType) {
        this.provinceType = provinceType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}
