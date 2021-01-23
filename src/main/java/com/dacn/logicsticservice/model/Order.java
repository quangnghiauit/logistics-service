package com.dacn.logicsticservice.model;


import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.utils.DateTimeUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

//    @Column(name ="RulID")
//    private int rulID;

    @Column(name ="CusID")
    private int cusID;

    @Column(name ="CreatedDate")
    private String createdDate;

    @Column(name ="Status")
    private int status;

    @Column(name ="TotalAmount")
    private float totalAmount;

    @Column(name ="ReceiverName")
    private String receiverName;

    @Column(name ="ReceiverPhone")
    private int receiverPhone;

    @Column(name ="ReceiverLocation")
    private int receiveLocation;

    @Column(name ="VolumeProduction")
    private float volumeProduction;

    @Column(name ="TypeProduct")
    private String typeProduct;

    @Column(name ="Description")
    private String description;

    @Column(name ="SenderName")
    private String senderName;

    @Column(name ="SenderPhone")
    private long senderPhone;

    @Column(name ="SenderLocation")
    private int senderLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void doMappingEntity(OrderRequest request, CMLocation receiverLocation, CMLocation senderLocation) {
//        this.rulID = request.getRulID();
//        this.cusID = request.getCusID();
//        this.status = request.getStatus();
        this.totalAmount = request.getTotalAmount();
        this.receiverName = request.getReceiverName();
        this.receiverPhone = Integer.parseInt(request.getReceiverPhone());

        if (receiverLocation != null) {
            this.receiveLocation = receiverLocation.getId();
        }

        this.volumeProduction = request.getVolumeProduction();
        this.typeProduct = request.getTypeProduct();
        this.description = request.getDescription();
        this.createdDate = DateTimeUtils.getCurrentDateTime();

        this.senderName = request.getSenderName();
        if (NumberUtils.isDigits(request.getSenderPhone())) {
            this.senderPhone = Long.parseLong(request.getSenderPhone());
        }

        if (senderLocation != null) {
            this.senderLocation = senderLocation.getId();
        }
    }
}
