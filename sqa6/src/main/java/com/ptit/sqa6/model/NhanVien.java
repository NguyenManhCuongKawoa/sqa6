package com.ptit.sqa6.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nhan_vien")
public class NhanVien extends User {
    private String vitri;

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
}
