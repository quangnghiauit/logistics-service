package com.dacn.logicsticservice.dto.request;

import javax.persistence.Column;
import java.util.List;

public class OrderRequest {
    private int cusID;
    private int rulID;
    private int status;
    private float totalAmount;
    private float volumeProduction;
    private String createdDate;
    private String receiverName;
    private String receiverPhone;
    private String wardIdReceiver;
    private String districtIdReceiver;
    private String provinceIdReceiver;
    private String locDescriptionReceiver;
    private String senderName;
    private String senderPhone;
    private String wardIdSender;
    private String districtIdSender;
    private String provinceIdSender;
    private String locDescriptionSender;
    private String typeProduct;
    private String description;
    private List<Integer> rulrateIds;
    private String expectedDate;
    private String recieveAddress;
    private String senderAddress;

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public int getRulID() {
        return rulID;
    }

    public void setRulID(int rulID) {
        this.rulID = rulID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getVolumeProduction() {
        return volumeProduction;
    }

    public void setVolumeProduction(float volumeProduction) {
        this.volumeProduction = volumeProduction;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getWardIdReceiver() {
        return wardIdReceiver;
    }

    public void setWardIdReceiver(String wardIdReceiver) {
        this.wardIdReceiver = wardIdReceiver;
    }

    public String getDistrictIdReceiver() {
        return districtIdReceiver;
    }

    public void setDistrictIdReceiver(String districtIdReceiver) {
        this.districtIdReceiver = districtIdReceiver;
    }

    public String getProvinceIdReceiver() {
        return provinceIdReceiver;
    }

    public void setProvinceIdReceiver(String provinceIdReceiver) {
        this.provinceIdReceiver = provinceIdReceiver;
    }

    public String getLocDescriptionReceiver() {
        return locDescriptionReceiver;
    }

    public void setLocDescriptionReceiver(String locDescriptionReceiver) {
        this.locDescriptionReceiver = locDescriptionReceiver;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getWardIdSender() {
        return wardIdSender;
    }

    public void setWardIdSender(String wardIdSender) {
        this.wardIdSender = wardIdSender;
    }

    public String getDistrictIdSender() {
        return districtIdSender;
    }

    public void setDistrictIdSender(String districtIdSender) {
        this.districtIdSender = districtIdSender;
    }

    public String getProvinceIdSender() {
        return provinceIdSender;
    }

    public void setProvinceIdSender(String provinceIdSender) {
        this.provinceIdSender = provinceIdSender;
    }

    public String getLocDescriptionSender() {
        return locDescriptionSender;
    }

    public void setLocDescriptionSender(String locDescriptionSender) {
        this.locDescriptionSender = locDescriptionSender;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public List<Integer> getRulrateIds() {
        return rulrateIds;
    }

    public void setRulrateIds(List<Integer> rulrateIds) {
        this.rulrateIds = rulrateIds;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getRecieveAddress() {
        return recieveAddress;
    }

    public void setRecieveAddress(String recieveAddress) {
        this.recieveAddress = recieveAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
}
