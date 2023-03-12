package com.ptit.sqa6.service.dto;

import java.util.List;

public class EnterPointDTO {
    private Long monhocId;
    private List<ItemEnterPoint> points;

    public Long getMonhocId() {
        return monhocId;
    }

    public void setMonhocId(Long monhocId) {
        this.monhocId = monhocId;
    }

    public List<ItemEnterPoint> getPoints() {
        return points;
    }

    public void setPoints(List<ItemEnterPoint> points) {
        this.points = points;
    }

    public static class ItemEnterPoint {
        private Long svId;
        private Long dauDiemId;
        private Double point;

        public Long getSvId() {
            return svId;
        }

        public void setSvId(Long svId) {
            this.svId = svId;
        }

        public Long getDauDiemId() {
            return dauDiemId;
        }

        public void setDauDiemId(Long dauDiemId) {
            this.dauDiemId = dauDiemId;
        }

        public Double getPoint() {
            return point;
        }

        public void setPoint(Double point) {
            this.point = point;
        }
    }
}
