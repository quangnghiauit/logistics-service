package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cmcurrency")
public class CMCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private int id;

    @Column(name = "CurCode")
    private String curCode;

    @Column(name = "CurName")
    private String curName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }
}
