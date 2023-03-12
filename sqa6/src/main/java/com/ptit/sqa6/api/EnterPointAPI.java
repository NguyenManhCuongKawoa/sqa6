package com.ptit.sqa6.api;

import com.ptit.sqa6.model.DiemSV;
import com.ptit.sqa6.model.MonHocDauDiem;
import com.ptit.sqa6.repository.DiemSVRepository;
import com.ptit.sqa6.repository.MdDdRepository;
import com.ptit.sqa6.repository.MonHocRepository;
import com.ptit.sqa6.service.dto.EnterPointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/enter-point")
public class EnterPointAPI {
    private final Logger log = LoggerFactory.getLogger(EnterPointAPI.class);

    @Autowired
    private DiemSVRepository diemSVRepository;

    @Autowired
    private MonHocRepository monHocRepository;

    @Autowired
    private MdDdRepository mdDdRepository;

    @PostMapping
    public ResponseEntity<?> enterPoint(@RequestBody EnterPointDTO enterPointDTO) {
        if(!monHocRepository.existsById(enterPointDTO.getMonhocId())) {
            return ResponseEntity.badRequest().body("Not Found MonHoc");
        }

        List<DiemSV> diemSVS = new ArrayList<>();
        for(EnterPointDTO.ItemEnterPoint e : enterPointDTO.getPoints()) {
            DiemSV diemSV = new DiemSV();
            diemSV.setPoint(e.getPoint());
            diemSV.setSvId(e.getSvId());

            List<MonHocDauDiem> dauDiems = mdDdRepository.findAllByDauDiemIdAndMonHocId(e.getDauDiemId(), enterPointDTO.getMonhocId());
            if(dauDiems.isEmpty()) {
                return ResponseEntity.badRequest().body("Monhoc is not config dau diem");
            }
            diemSV.setMonHocDauDiemId(dauDiems.get(0).getId());

            diemSVS.add(diemSV);
        }

        diemSVRepository.saveAll(diemSVS);

        return ResponseEntity.ok(enterPointDTO);
    }

}
