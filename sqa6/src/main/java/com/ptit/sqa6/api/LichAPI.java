package com.ptit.sqa6.api;

import com.ptit.sqa6.model.*;
import com.ptit.sqa6.repository.*;
import com.ptit.sqa6.service.dto.LichResponse;
import com.ptit.sqa6.utils.DBConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/calendar")
public class LichAPI {
    private final Logger log = LoggerFactory.getLogger(LichAPI.class);

    @Autowired
    private LichRepository lichRepository;

    @Autowired
    private LichSVRepository lichSVRepository;

    @Autowired
    private MdDdRepository mdDdRepository;

    @Autowired
    private DauDiemRepository dauDiemRepository;

    @Autowired
    private SVRepository svRepository;

    @Autowired
    private DiemSVRepository diemSVRepository;

    @GetMapping
    public ResponseEntity<?> getAllCalendarOfTeacher(@RequestParam Long teacherId, Pageable pageable) {
        log.debug("REST request to get a page of Lich ");
        Page<Lich> page = lichRepository.findAllByGvId(teacherId, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("info-class")
    public ResponseEntity<?> getAllStudentInCalendar(@RequestParam Long calendarId, Pageable pageable) {
        log.debug("REST request to get a page of student in calendar ");
        Optional<Lich> lichOptional = lichRepository.findById(calendarId);

        if(lichOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Not Found Calendar");
        }

        Lich lich = lichOptional.get();

        List<MonHocDauDiem> monHocDauDiems = mdDdRepository.findAllByMonHocId(lich.getMonHocId());

        List<LichSV> lichSVS = lichSVRepository.findAllByLichId(calendarId);

        LichResponse lichResponse = new LichResponse();
        lichResponse.setName(lich.getName());
        lichResponse.setAddress(lich.getAddress());
        lichResponse.setStart(lich.getStart());
        lichResponse.setEnd(lich.getEnd());
        lichResponse.setGvId(lich.getGvId());
        lichResponse.setMonHocId(lich.getMonHocId());

        List<LichResponse.LichDauDiem> lichDauDiems = monHocDauDiems.stream().map(d -> {
            LichResponse.LichDauDiem lichDauDiem = new LichResponse.LichDauDiem();
            lichDauDiem.setDauDiemId(d.getDauDiemId());
            lichDauDiem.setMonHocId(d.getMonHocId());
            lichDauDiem.setPhanTram(d.getPhanTram());

            DauDiem dauDiem = dauDiemRepository.findById(d.getDauDiemId()).orElse(new DauDiem());
            lichDauDiem.setName(dauDiem.getName());

            return lichDauDiem;
        }).collect(Collectors.toList());
        lichResponse.setDauDiems(lichDauDiems);

        List<LichResponse.LichSv> lichSvs = lichSVS.stream().map(lsv -> {
            LichResponse.LichSv lichSv = new LichResponse.LichSv();
            SinhVien sinhVien = svRepository.findById(lsv.getSvId()).orElse(new SinhVien());

            lichSv.setSvId(sinhVien.getId());
            lichSv.setName(sinhVien.getName());
            lichSv.setMasv(sinhVien.getMasv());

            List<Double> points = monHocDauDiems.stream().map(m -> {
                DiemSV diemSV = diemSVRepository.findBySvIdAndMonHocDauDiemId(lsv.getSvId(), m.getId()).orElse(new DiemSV());

                return diemSV.getPoint();
            }).collect(Collectors.toList());
            lichSv.setPoints(points);

            Double point = 0.0;
            for(int i = 0; i < points.size(); i++) {
                point += points.get(i) * monHocDauDiems.get(i).getPhanTram();
            }

            if(point >= DBConstants.PART_POINT) {
                lichSv.setPast(true);
            } else {
                lichSv.setPast(false);
            }

            return lichSv;
        }).collect(Collectors.toList());


        lichResponse.setSv(lichSvs);

        return ResponseEntity.ok(lichResponse);
    }
}
