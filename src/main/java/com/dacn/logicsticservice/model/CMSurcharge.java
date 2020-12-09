package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cmsurcharge")
public class CMSurcharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

    @Column(name = "SurCode")
    private String surCode;

    @Column(name = "SurName")
    private String surName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurCode() {
        return surCode;
    }

    public void setSurCode(String surCode) {
        this.surCode = surCode;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
