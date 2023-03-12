package com.ptit.sqa6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mon_hoc")
public class MonHoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String des;
    @Column(name = "bo_mon_id")
    private Long boMonId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Long getBoMonId() {
        return boMonId;
    }

    public void setBoMonId(Long boMonId) {
        this.boMonId = boMonId;
    }
}
