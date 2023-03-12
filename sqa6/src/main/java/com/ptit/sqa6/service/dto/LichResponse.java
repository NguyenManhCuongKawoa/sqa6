package com.ptit.sqa6.service.dto;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

public class LichResponse {
    private String name;
    private String address;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long gvId;
    private Long monHocId;
    private List<LichDauDiem> dauDiems;

    private List<LichSv> sv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Long getGvId() {
        return gvId;
    }

    public void setGvId(Long gvId) {
        this.gvId = gvId;
    }

    public Long getMonHocId() {
        return monHocId;
    }

    public void setMonHocId(Long monHocId) {
        this.monHocId = monHocId;
    }

    public List<LichDauDiem> getDauDiems() {
        return dauDiems;
    }

    public void setDauDiems(List<LichDauDiem> dauDiems) {
        this.dauDiems = dauDiems;
    }

    public List<LichSv> getSv() {
        return sv;
    }

    public void setSv(List<LichSv> sv) {
        this.sv = sv;
    }

    public static class LichSv {
        private Long svId;
        private String name;
        private String masv;
        private List<Double> points;
        private Boolean past;

        public Long getSvId() {
            return svId;
        }

        public void setSvId(Long svId) {
            this.svId = svId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMasv() {
            return masv;
        }

        public void setMasv(String masv) {
            this.masv = masv;
        }

        public List<Double> getPoints() {
            return points;
        }

        public void setPoints(List<Double> points) {
            this.points = points;
        }

        public Boolean getPast() {
            return past;
        }

        public void setPast(Boolean past) {
            this.past = past;
        }
    }

    public static class LichDauDiem {
        private Long monHocId;
        private Long dauDiemId;
        private Double phanTram;
        private String name;

        public Long getMonHocId() {
            return monHocId;
        }

        public void setMonHocId(Long monHocId) {
            this.monHocId = monHocId;
        }

        public Long getDauDiemId() {
            return dauDiemId;
        }

        public void setDauDiemId(Long dauDiemId) {
            this.dauDiemId = dauDiemId;
        }

        public Double getPhanTram() {
            return phanTram;
        }

        public void setPhanTram(Double phanTram) {
            this.phanTram = phanTram;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
