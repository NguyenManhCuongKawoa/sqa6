package com.ptit.sqa6.api;

import com.ptit.sqa6.model.NhanVien;
import com.ptit.sqa6.model.SinhVien;
import com.ptit.sqa6.repository.NVRepository;
import com.ptit.sqa6.repository.SVRepository;
import com.ptit.sqa6.service.dto.LoginDTO;
import com.ptit.sqa6.service.dto.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserAPI {
    private final Logger log = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    private NVRepository nvRepository;

    @Autowired
    private SVRepository svRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        log.debug("REST request to login");
        LoginResponse loginResponse = new LoginResponse();
        Optional<SinhVien> sinhVien = svRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()) ;
        if(sinhVien.isPresent()) {
            loginResponse.setCode(200);
            loginResponse.setMessage("Login successfully");
            loginResponse.setRole("SINH_VIEN");
            loginResponse.setData(sinhVien.get());
            return ResponseEntity.ok(loginResponse);
        }

        Optional<NhanVien> nv = nvRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()) ;
        if(nv.isPresent()) {
            loginResponse.setCode(200);
            loginResponse.setMessage("Login successfully");
            loginResponse.setRole(nv.get().getVitri());
            loginResponse.setData(nv.get());
            return ResponseEntity.ok(loginResponse);
        }

        return ResponseEntity.badRequest().body("Login fail");
    }
}
