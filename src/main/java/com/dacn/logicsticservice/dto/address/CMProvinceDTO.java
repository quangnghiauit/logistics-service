package com.dacn.logicsticservice.dto.address;

import com.dacn.logicsticservice.model.CMProvince;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class CMProvinceDTO {

    private String provinceId;
    private String nationId;
    private String provinceCode;
    private String provinceName;
    private String provinceType;
    private String note;
    private String createdDate;
    private String modifiedDate;
    private int isDeleted;
    private String createdBy;
    private String modifiedBy;
    private String authStatus;
    private String approvedDate;
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

    public void mappingEntityToDTO(CMProvince entity) {
        this.provinceId = entity.getProvinceId();
        this.nationId = entity.getNationId();
        this.provinceCode = entity.getProvinceCode();
        this.provinceName = entity.getProvinceName();
        this.provinceType = entity.getProvinceType();
        this.note = entity.getNote();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.isDeleted = entity.getIsDeleted();
        this.createdBy = entity.getCreatedBy();
        this.modifiedBy = entity.getModifiedBy();
        this.authStatus = entity.getAuthStatus();
        this.approvedDate = entity.getApprovedDate();
        this.approvedBy = entity.getApprovedBy();
    }
}
