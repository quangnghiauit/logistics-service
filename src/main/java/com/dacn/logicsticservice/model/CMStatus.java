package com.dacn.logicsticservice.model;


import javax.persistence.*;

@Entity
@Table(name = "cmstatus")
public class CMStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private Integer id;

    @Column(name ="Name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
