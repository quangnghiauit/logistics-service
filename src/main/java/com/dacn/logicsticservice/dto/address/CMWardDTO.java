package com.dacn.logicsticservice.dto.address;

import com.dacn.logicsticservice.model.CMWard;

public class CMWardDTO {

    private String wardId;
    private String districtId;
    private String wardCode;
    private String wardName;
    private String wardType;
    private String note;
    private String createdDate;
    private String modifiedDate;
    private int isDeleted;
    private String createdBy;
    private String modifiedBy;
    private String authStatus;
    private String approvedDate;
    private String approvedBy;

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType(String wardType) {
        this.wardType = wardType;
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

    public void mappingEntityToDTO(CMWard entity) {
        this.wardId = entity.getWardId();
        this.districtId = entity.getDistrictId();
        this.wardCode = entity.getWardCode();
        this.wardName = entity.getWardName();
        this.wardType = entity.getWardType();
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
