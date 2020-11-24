package com.dacn.logicsticservice.dto.trans;


import com.dacn.logicsticservice.model.Company;

public class CompanyDTO {

    private String id;
    private String coCode;
    private String coName;
    private String coDescription;
    private String coAddress1;
    private String coAddress2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoCode() {
        return coCode;
    }

    public void setCoCode(String coCode) {
        this.coCode = coCode;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public String getCoDescription() {
        return coDescription;
    }

    public void setCoDescription(String coDescription) {
        this.coDescription = coDescription;
    }

    public String getCoAddress1() {
        return coAddress1;
    }

    public void setCoAddress1(String coAddress1) {
        this.coAddress1 = coAddress1;
    }

    public String getCoAddress2() {
        return coAddress2;
    }

    public void setCoAddress2(String coAddress2) {
        this.coAddress2 = coAddress2;
    }

    public void mappingEntityToDTO(Company entity) {
        this.id = entity.getId();
        this.coCode = entity.getCoCode();
        this.coName = entity.getCoName();
        this.coDescription = entity.getCoDescription();
        this.coAddress1 = entity.getCoAddress1();
        this.coAddress2 = entity.getCoAddress2();
    }
}
