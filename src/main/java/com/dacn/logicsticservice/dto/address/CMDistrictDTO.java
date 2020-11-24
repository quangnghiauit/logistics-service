package com.dacn.logicsticservice.dto.address;

import com.dacn.logicsticservice.model.CMDistrict;

public class CMDistrictDTO {

    private String provinceId;
    private String districtId;
    private String districtCode;
    private String districtName;
    private String districtType;
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

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictType() {
        return districtType;
    }

    public void setDistrictType(String districtType) {
        this.districtType = districtType;
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

    public void mappingEntityToDTO(CMDistrict entity) {
        this.provinceId = entity.getProvinceId();
        this.districtId = entity.getDistrictId();
        this.districtCode = entity.getDistrictCode();
        this.districtName = entity.getDistrictName();
        this.districtType = entity.getDistrictType();
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
