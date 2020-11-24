package com.dacn.logicsticservice.model;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "CusCode")
    private String cusCode;

    @Column(name = "CusFirstName")
    private String cusFirstName;

    @Column(name = "CusAddress")
    private String cusAddress;

    @Column(name = "CusPhone")
    private long cusPhone;

    @Column(name = "CusLastName")
    private String cusLastName;

    @Column(name = "CusDescription")
    private String cusDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public long getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(long cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusLastName() {
        return cusLastName;
    }

    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }

    public String getCusDescription() {
        return cusDescription;
    }

    public void setCusDescription(String cusDescription) {
        this.cusDescription = cusDescription;
    }
}
