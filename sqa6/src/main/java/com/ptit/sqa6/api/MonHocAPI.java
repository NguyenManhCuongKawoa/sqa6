package com.ptit.sqa6.api;

import com.ptit.sqa6.model.MonHoc;
import com.ptit.sqa6.model.MonHocDauDiem;
import com.ptit.sqa6.repository.MonHocRepository;
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

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class MonHocAPI {

    private final Logger log = LoggerFactory.getLogger(MonHocAPI.class);

    @Autowired
    private MonHocRepository monHocRepository;

    @GetMapping
    public ResponseEntity<?> getMonHoc(Pageable pageable) {
        log.debug("REST request to get all MonHoc");
        Page<MonHoc> monhocs = monHocRepository.findAll(pageable);

        return ResponseEntity.ok(monhocs);
    }
}
