package com.dacn.logicsticservice.model;

import javax.persistence.*;

@Entity
@Table(name = "weightrank")
public class WeightRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "weightmin")
    private float weightmin;

    @Column(name = "weightmax")
    private float weightmax;

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

    public float getWeightmin() {
        return weightmin;
    }

    public void setWeightmin(float weightmin) {
        this.weightmin = weightmin;
    }

    public float getWeightmax() {
        return weightmax;
    }

    public void setWeightmax(float weightmax) {
        this.weightmax = weightmax;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }
}
