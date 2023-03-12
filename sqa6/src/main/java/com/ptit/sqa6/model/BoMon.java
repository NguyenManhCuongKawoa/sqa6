package com.ptit.sqa6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bo_mon")
public class BoMon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String des;
    @Column(name = "khoa_id")
    private Long khoaId;

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

    public Long getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(Long khoaId) {
        this.khoaId = khoaId;
    }
}
