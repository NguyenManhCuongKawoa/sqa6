package com.ptit.sqa6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "khoa")
public class Khoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String des;
    @Column(name = "truong_id")
    private Long truongId;

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

    public Long getTruongId() {
        return truongId;
    }

    public void setTruongId(Long truongId) {
        this.truongId = truongId;
    }
}
