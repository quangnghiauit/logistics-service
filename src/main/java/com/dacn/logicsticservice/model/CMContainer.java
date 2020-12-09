package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "cmcontainer")
public class CMContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private int id;

    @Column(name = "ContCode")
    private String contCode;

    @Column(name = "ContName")
    private String contName;

    @Column(name = "ContWeight")
    private float contWeight;

    @Column(name = "TypeWeight")
    private String typeWeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public float getContWeight() {
        return contWeight;
    }

    public void setContWeight(float contWeight) {
        this.contWeight = contWeight;
    }

    public String getTypeWeight() {
        return typeWeight;
    }

    public void setTypeWeight(String typeWeight) {
        this.typeWeight = typeWeight;
    }
}
