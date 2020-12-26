package com.dacn.logicsticservice.dto.trans;


import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.model.CMLocation;
import com.dacn.logicsticservice.model.Order;
import com.dacn.logicsticservice.utils.DateTimeUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;

public class OrderDTO {

    private int id;
    private int rulID;
    private int cusID;
    private String createdDate;
    private int status;
    private float totalAmount;
    private String receiverName;
    private int receiverPhone;
    private int receiveLocation;
    private float volumeProduction;
    private String typeProduct;
    private String description;
    private String senderName;
    private long senderPhone;
    private int senderLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRulID() {
        return rulID;
    }

    public void setRulID(int rulID) {
        this.rulID = rulID;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
        this.cusID = cusID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiveName) {
        this.receiverName = receiveName;
    }

    public int getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(int receivePhone) {
        this.receiverPhone = receivePhone;
    }

    public float getVolumeProduction() {
        return volumeProduction;
    }

    public void setVolumeProduction(float volumeProduction) {
        this.volumeProduction = volumeProduction;
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

    public int getReceiveLocation() {
        return receiveLocation;
    }

    public void setReceiveLocation(int receiveLocation) {
        this.receiveLocation = receiveLocation;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public long getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(long senderPhone) {
        this.senderPhone = senderPhone;
    }

    public int getSenderLocation() {
        return senderLocation;
    }

    public void setSenderLocation(int senderLocation) {
        this.senderLocation = senderLocation;
    }

    public void doMappingEntity(Order request) {
        this.rulID = request.getRulID();
        this.cusID = request.getCusID();
        this.status = request.getStatus();
        this.totalAmount = request.getTotalAmount();
        this.receiverName = request.getReceiverName();
        this.receiverPhone = request.getReceiverPhone();
        this.receiveLocation = request.getReceiveLocation();
        this.volumeProduction = request.getVolumeProduction();
        this.typeProduct = request.getTypeProduct();
        this.description = request.getDescription();
        this.createdDate = request.getCreatedDate();
        this.senderPhone = request.getSenderPhone();
        this.senderName = request.getSenderName();
        this.senderLocation = request.getSenderLocation();
    }
}
