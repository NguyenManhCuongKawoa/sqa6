package com.ptit.sqa6.api;

import com.ptit.sqa6.model.DauDiem;
import com.ptit.sqa6.repository.DauDiemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dau-diem")
public class DauDiemAPI {
    private final Logger log = LoggerFactory.getLogger(DauDiemAPI.class);
    @Autowired
    private DauDiemRepository dauDiemRepository;

    @GetMapping
    public ResponseEntity<?> getAllDauDiem(Pageable pageable) {
        log.debug("REST request to get a page of DauDiem");
        Page<DauDiem> page = dauDiemRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }
}
