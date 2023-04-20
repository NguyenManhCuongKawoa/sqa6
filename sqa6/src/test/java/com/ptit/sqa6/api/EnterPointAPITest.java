package com.ptit.sqa6.api;

import com.ptit.sqa6.service.dto.EnterPointDTO;
import com.ptit.sqa6.util.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class EnterPointAPITest {

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDefaultCategoryMockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test nhập điểm cho môn học không có")
    @Transactional
    void enterPoint() throws Exception {
        EnterPointDTO enterPointDTO = new EnterPointDTO();
        enterPointDTO.setMonhocId(99999L);

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/enter-point")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(TestUtil.convertObjectToJsonBytes(enterPointDTO))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Not Found MonHoc"));
    }

    @Test
    @DisplayName("Test nhập điểm cho môn học nhưng chưa cấu hình đầu điểm")
    @Transactional
    void enterPointNotConfigFactor() throws Exception {
        EnterPointDTO enterPointDTO = new EnterPointDTO();
        enterPointDTO.setMonhocId(3L);
        List<EnterPointDTO.ItemEnterPoint> points = new ArrayList<>();
        points.add(new EnterPointDTO.ItemEnterPoint(1L, 1L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(1L, 2L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(1L, 3L, 9.0));
        enterPointDTO.setPoints(points);

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/enter-point")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(enterPointDTO))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Monhoc is not config dau diem"));
    }

    @Test
    @DisplayName("Test nhập điểm cho môn học thành công")
    @Transactional
    void enterPointSuccessfully() throws Exception {
        EnterPointDTO enterPointDTO = new EnterPointDTO();
        enterPointDTO.setMonhocId(1L);
        List<EnterPointDTO.ItemEnterPoint> points = new ArrayList<>();
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 1L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 2L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 3L, 9.0));
        enterPointDTO.setPoints(points);

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/enter-point")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(enterPointDTO))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.monhocId").value(1))
                .andExpect(jsonPath("$.points[*].svId").value(hasItem(3)))
                .andExpect(jsonPath("$.points[*].dauDiemId").value(hasItem(1)))
                .andExpect(jsonPath("$.points[*].point").value(hasItem(9.0)));
    }

    @Test
    @DisplayName("Test nhập điểm cho môn học điểm nhỏ hơn 0")
    @Transactional
    void enterPointNotValidPointLessThanZero() throws Exception {
        EnterPointDTO enterPointDTO = new EnterPointDTO();
        enterPointDTO.setMonhocId(1L);
        List<EnterPointDTO.ItemEnterPoint> points = new ArrayList<>();
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 1L, -1.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 2L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 3L, 9.0));
        enterPointDTO.setPoints(points);

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/enter-point")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(enterPointDTO))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Diem cua mon hoc phai lon hon hoac bang 0"));
    }

    @Test
    @DisplayName("Test nhập điểm cho môn học điểm lớn hơn 10")
    @Transactional
    void enterPointNotValidPointGreaterThanTen() throws Exception {
        EnterPointDTO enterPointDTO = new EnterPointDTO();
        enterPointDTO.setMonhocId(1L);
        List<EnterPointDTO.ItemEnterPoint> points = new ArrayList<>();
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 1L, 11.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 2L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 3L, 9.0));
        enterPointDTO.setPoints(points);

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/enter-point")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(enterPointDTO))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Diem cua mon hoc phai nho hon hoac bang 10"));
    }

    @Test
    @DisplayName("Test nhập điểm cho môn học điểm khong phai la so")
    @Transactional
    void enterPointNotValidNotCharacter() throws Exception {
        EnterPointDTO enterPointDTO = new EnterPointDTO();
        enterPointDTO.setMonhocId(1L);
        List<EnterPointDTO.ItemEnterPoint> points = new ArrayList<>();
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 1L, Double.parseDouble("abc")));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 2L, 9.0));
        points.add(new EnterPointDTO.ItemEnterPoint(3L, 3L, 9.0));
        enterPointDTO.setPoints(points);

        restDefaultCategoryMockMvc
                .perform(
                        post("/api/enter-point")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TestUtil.convertObjectToJsonBytes(enterPointDTO))
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(jsonPath("$").value("Diem cua mon hoc phai la so"));
    }
}