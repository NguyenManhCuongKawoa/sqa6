package com.ptit.sqa6.api;

import com.ptit.sqa6.model.MonHocDauDiem;
import com.ptit.sqa6.service.dto.EnterPointDTO;
import com.ptit.sqa6.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class ConfigPointAPITest {

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDefaultCategoryMockMvc;

    @Test
    @DisplayName("Test lấy hệ số điểm với môn học không tồn tại")
    @Transactional
    void getDauDiemMonHocWithNotValidMonHoc() throws Exception {
        Long monhocId = 88L;

        restDefaultCategoryMockMvc
                .perform(get("/api/config-point?monHocId=" + monhocId ))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Not Found MonHoc"));
    }

    @Test
    @DisplayName("Test lấy hệ số điểm với môn học tồn tại")
    @Transactional
    void getDauDiemMonHocWithValidMonHoc() throws Exception {
        Long monhocId = 1L;

        restDefaultCategoryMockMvc
                .perform(get("/api/config-point?monHocId=" + monhocId ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].monHocId").value(hasItem(1)))
                .andExpect(jsonPath("$.[*].dauDiemId").value(hasItem(1)))
                .andExpect(jsonPath("$.[*].phanTram").value(hasItem(0.3)));
    }

    @Test
    @DisplayName("Test lấy hệ số điểm với môn học có id là chữ")
    @Transactional
    void getDauDiemMonHocWithNotValidMonHocId() throws Exception {

        restDefaultCategoryMockMvc
                .perform(get("/api/config-point?monHocId=abc"  ))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Id mon hoc khong hop le"));
    }


    @Test
    @DisplayName("Test cấu hinh cho môn học với môn học không tồn tại")
    @Transactional
    void configPointWithNotFoundMonHocId() throws Exception {
        Long monHocId = 88L;
        List<MonHocDauDiem> monHocDauDiems = new ArrayList<>();

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/config-point?monHocId=" + monHocId  )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(monHocDauDiems))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Not Found MonHoc"));
    }

    @Test
    @DisplayName("Test POST cấu hinh cho môn học với môn học đã được cấu hình")
    @Transactional
    void configPointWithAlreadyMonHoc() throws Exception {
        Long monHocId = 1L;
        List<MonHocDauDiem> monHocDauDiems = new ArrayList<>();

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/config-point?monHocId=" + monHocId  )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(monHocDauDiems))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Monhoc already config DauDiem"));
    }

    @Test
    @DisplayName("Test POST cấu hinh cho môn học với tổng hệ số không bằng 1")
    @Transactional
    void configPointWithTotalNotEqualOne() throws Exception {
        Long monHocId = 3L;
        List<MonHocDauDiem> monHocDauDiems = new ArrayList<>();
        monHocDauDiems.add(new MonHocDauDiem(monHocId, 1L, 0.8));
        monHocDauDiems.add(new MonHocDauDiem(monHocId, 2L, 0.8));
        monHocDauDiems.add(new MonHocDauDiem(monHocId, 3L, 0.8));

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/config-point?monHocId=" + monHocId  )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(monHocDauDiems))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Total percent is not equal 100%"));
    }

    @Test
    @DisplayName("Test POST cấu hinh cho môn học thành công")
    @Transactional
    void configPointSuccessfully() throws Exception {
        Long monHocId = 3L;
        List<MonHocDauDiem> monHocDauDiems = new ArrayList<>();
        monHocDauDiems.add(new MonHocDauDiem(monHocId, 1L, 0.2));
        monHocDauDiems.add(new MonHocDauDiem(monHocId, 2L, 0.2));
        monHocDauDiems.add(new MonHocDauDiem(monHocId, 3L, 0.6));

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/config-point?monHocId=" + monHocId  )
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(monHocDauDiems))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[*].monHocId").value(hasItem(3)))
                .andExpect(jsonPath("$.[*].dauDiemId").value(hasItem(1)))
                .andExpect(jsonPath("$.[*].phanTram").value(hasItem(0.6)));
    }
}