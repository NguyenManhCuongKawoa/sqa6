package com.ptit.sqa6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diem_sv")
public class DiemSV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sv_id")
    private Long svId;

    @Column(name = "monhocdaudiem_id")
    private Long monHocDauDiemId;
    private Double point;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSvId() {
        return svId;
    }

    public void setSvId(Long svId) {
        this.svId = svId;
    }

    public Long getMonHocDauDiemId() {
        return monHocDauDiemId;
    }

    public void setMonHocDauDiemId(Long monHocDauDiemId) {
        this.monHocDauDiemId = monHocDauDiemId;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
