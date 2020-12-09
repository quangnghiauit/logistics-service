package com.dacn.logicsticservice.dto.request;

public class SuggestRequest {

    private String wardIdSender;
    private String districtIdSender;
    private String provinceIdSender;
    private String locDescriptionSender;
    private String wardIdReceiver;
    private String districtIdReceiver;
    private String provinceIdReceiver;
    private String locDescriptionReceiver;
    private int volumeProduct;
    private float routTransitTime;

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

    public int getVolumeProduct() {
        return volumeProduct;
    }

    public void setVolumeProduct(int volumeProduct) {
        this.volumeProduct = volumeProduct;
    }

    public float getRoutTransitTime() {
        return routTransitTime;
    }

    public void setRoutTransitTime(float routTransitTime) {
        this.routTransitTime = routTransitTime;
    }
}
