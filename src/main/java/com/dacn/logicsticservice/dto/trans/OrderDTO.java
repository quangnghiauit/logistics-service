package com.dacn.logicsticservice.dto.trans;


import com.dacn.logicsticservice.model.CMLocation;
import com.dacn.logicsticservice.model.Customer;
import com.dacn.logicsticservice.model.Order;

public class OrderDTO {

    private int orderId;
//    private int rulID;
    private int cusID;
    private Customer customerInfo;
    private String createdDate;
    private int status;
    private String statusMessage;
    private float totalAmount;
    private RulRateDTO rulRate;
    private String receiverName;
    private int receiverPhone;
    private float volumeProduction;
    private String typeProduct;
    private String description;
    private String senderName;
    private long senderPhone;
    private CMLocation receiverLocation;
    private CMLocation senderLocation;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

//    public int getRulID() {
//        return rulID;
//    }
//
//    public void setRulID(int rulID) {
//        this.rulID = rulID;
//    }

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

    public CMLocation getReceiverLocation() {
        return receiverLocation;
    }

    public void setReceiverLocation(CMLocation receiverLocation) {
        this.receiverLocation = receiverLocation;
    }

    public CMLocation getSenderLocation() {
        return senderLocation;
    }

    public void setSenderLocation(CMLocation senderLocation) {
        this.senderLocation = senderLocation;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Customer getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(Customer customerInfo) {
        this.customerInfo = customerInfo;
    }

    public RulRateDTO getRulRate() {
        return rulRate;
    }

    public void setRulRate(RulRateDTO rulRate) {
        this.rulRate = rulRate;
    }

    public void doMappingEntity(Order request) {
        this.orderId = request.getId();
        this.cusID = request.getCusID();
        this.status = request.getStatus();
        this.totalAmount = request.getTotalAmount();
        this.receiverName = request.getReceiverName();
        this.receiverPhone = request.getReceiverPhone();
        this.volumeProduction = request.getVolumeProduction();
        this.typeProduct = request.getTypeProduct();
        this.description = request.getDescription();
        this.createdDate = request.getCreatedDate();
        this.senderPhone = request.getSenderPhone();
        this.senderName = request.getSenderName();
    }
}
