package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "rulsurcharge")
public class RulsurCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="RulRateID")
    private int id;

    @Column(name = "SurID")
    private int surID;

    @Column(name = "Amount")
    private float amount;

    @Column(name = "CurrencyId")
    private int currencyId;

    @Column(name = "Note")
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSurID() {
        return surID;
    }

    public void setSurID(int surID) {
        this.surID = surID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
