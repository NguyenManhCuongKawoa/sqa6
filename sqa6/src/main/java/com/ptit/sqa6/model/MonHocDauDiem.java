package com.ptit.sqa6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "monhoc_daudiem")
public class MonHocDauDiem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "monhoc_id")
    private Long monHocId;
    @Column(name = "daudiem_id")
    private Long dauDiemId;
    @Column(name = "pham_tram")
    private Double phanTram;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(Long monHocId) {
        this.monHocId = monHocId;
    }

    public Long getDauDiemId() {
        return dauDiemId;
    }

    public void setDauDiemId(Long dauDienId) {
        this.dauDiemId = dauDienId;
    }

    public Double getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(Double phanTram) {
        this.phanTram = phanTram;
    }
}
