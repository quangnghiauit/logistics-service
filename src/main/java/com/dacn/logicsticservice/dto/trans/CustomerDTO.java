package com.dacn.logicsticservice.dto.trans;


import com.dacn.logicsticservice.model.Customer;

import javax.persistence.*;

public class CustomerDTO {

    private String id;
    private String cusCode;
    private String cusFirstName;
    private String cusAddress;
    private long cusPhone;
    private String cusLastName;
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

    public void mappingEntityToDTO(Customer entity) {
        this.id = entity.getId();
        this.cusCode = entity.getCusCode();
        this.cusFirstName = entity.getCusFirstName();
        this.cusAddress = entity.getCusAddress();
        this.cusPhone = entity.getCusPhone();
        this.cusLastName = entity.getCusLastName();
        this.cusDescription = entity.getCusDescription();
    }
}
