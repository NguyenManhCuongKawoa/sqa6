package com.ptit.sqa6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lich_sv")
public class LichSV implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sv_id")
    private Long svId;
    @Column(name = "lich_id")
    private Long lichId;

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

    public Long getLichId() {
        return lichId;
    }

    public void setLichId(Long lichId) {
        this.lichId = lichId;
    }
}
