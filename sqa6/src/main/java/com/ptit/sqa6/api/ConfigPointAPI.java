package com.ptit.sqa6.api;

import com.ptit.sqa6.model.DauDiem;
import com.ptit.sqa6.model.MonHocDauDiem;
import com.ptit.sqa6.repository.MdDdRepository;
import com.ptit.sqa6.repository.MonHocRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/config-point")
public class ConfigPointAPI {
    private final Logger log = LoggerFactory.getLogger(ConfigPointAPI.class);

    @Autowired
    private MonHocRepository monHocRepository;
    @Autowired
    private MdDdRepository mdDdRepository;

    @GetMapping
    public ResponseEntity<?> getDauDiemOfMonHoc(@RequestParam Long monHocId) {
        log.debug("REST request to get a DauDiem of MonHoc");
        if(!monHocRepository.existsById(monHocId)) {
            return ResponseEntity.badRequest().body("Not Found MonHoc");
        }

        List<MonHocDauDiem> monHocDauDiems = mdDdRepository.findAllByMonHocId(monHocId);

        return ResponseEntity.ok(monHocDauDiems);
    }

    @PostMapping
    public ResponseEntity<?> setupDauDiem(@RequestParam Long monHocId, @RequestBody  List<MonHocDauDiem> monHocDauDiems) {
        log.debug("REST request to set up a DauDiem of MonHoc");

        if(!monHocRepository.existsById(monHocId)) {
            return ResponseEntity.badRequest().body("Not Found MonHoc");
        }

        List<MonHocDauDiem> existed = mdDdRepository.findAllByMonHocId(monHocId);
        if(existed != null && existed.size() > 0) {
            return ResponseEntity.badRequest().body("Monhoc already config DauDiem");
        }

        Double total = monHocDauDiems.stream().map(mm -> mm.getPhanTram()).reduce(0.0, (a, b) -> a + b);
        if(!total.equals(1.0)) {
            return ResponseEntity.badRequest().body("Total percent is not equal 100%");
        }
        monHocDauDiems = monHocDauDiems.stream().map(dd -> {
            dd.setMonHocId(monHocId);
            return dd;
        }).collect(Collectors.toList());
        mdDdRepository.saveAll(monHocDauDiems);
        return ResponseEntity.ok(monHocDauDiems);
    }

    @PutMapping
    public ResponseEntity<?> fixDauDiem(@RequestParam Long monHocId, @RequestBody  List<Double> percents) {
        log.debug("REST request to fix a DauDiem of MonHoc");

        if(!monHocRepository.existsById(monHocId)) {
            return ResponseEntity.badRequest().body("Not Found MonHoc");
        }

        List<MonHocDauDiem> dauDiems = mdDdRepository.findAllByMonHocId(monHocId);
        if(dauDiems.isEmpty()) {
            return ResponseEntity.badRequest().body("Monhoc is not config dau diem");
        }

        if(dauDiems.size() != percents.size()) {
            return ResponseEntity.badRequest().body("not enough percent to config");
        }

        Double total = percents.stream().reduce(0.0, (a, b) -> a + b);
        if(!total.equals(1.0)) {
            return ResponseEntity.badRequest().body("Total percent is not equal 100%");
        }

        for(int i = 0; i < percents.size(); i++) {
            dauDiems.get(i).setPhanTram(percents.get(i));
        }

        mdDdRepository.saveAll(dauDiems);
        return ResponseEntity.ok(dauDiems);
    }

}
