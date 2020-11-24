package com.dacn.logicsticservice.model;


import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "CoCode")
    private String coCode;

    @Column(name = "CoName")
    private String coName;

    @Column(name = "CoDescription")
    private String coDescription;

    @Column(name = "CoAddress1")
    private String coAddress1;

    @Column(name = "CoAddress2")
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
}
