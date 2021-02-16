package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Integer id;

    @Column(name ="OrderID")
    private int orderID;

    @Column(name ="RulID")
    private int rulID;

    @Column(name ="Status")
    private int status;

    @Column(name = "orderdetailcode")
    private String orderDetailCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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

    public String getOrderDetailCode() {
        return orderDetailCode;
    }

    public void setOrderDetailCode(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
    }
}
