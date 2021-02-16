package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "orderfeature")
public class OrderFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "ratio")
    private float ratio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
