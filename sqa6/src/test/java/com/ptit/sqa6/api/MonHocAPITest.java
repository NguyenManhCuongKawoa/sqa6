package com.ptit.sqa6.api;

import com.ptit.sqa6.model.MonHoc;
import com.ptit.sqa6.repository.MonHocRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class MonHocAPITest {

    @Autowired
    private MonHocRepository monHocRepository;

    private MonHoc monHoc;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDefaultCategoryMockMvc;

    public static MonHoc createEntity(EntityManager em) {
        MonHoc monHoc1 = new MonHoc();
        monHoc1.setBoMonId(1L);
        monHoc1.setName("Đảm bảo chất lượng phần mềm");
        monHoc1.setDes("Đảm bảo chất lượng phần mềm");
        return monHoc1;
    }

    @BeforeEach
    public void initTest() {
        monHoc = createEntity(em);
    }

    @Test
    @DisplayName("Test get all MonHoc")
    @Transactional
    void getMonHoc() throws Exception {
        monHocRepository.saveAndFlush(monHoc);

        restDefaultCategoryMockMvc
                .perform(get("/api/subject" ))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.content.[*].id").value(hasItem(monHoc.getId().intValue())))
                .andExpect(jsonPath("$.content.[*].name").value(hasItem(monHoc.getName())))
                .andExpect(jsonPath("$.content.[*].des").value(hasItem(monHoc.getDes())))
                .andExpect(jsonPath("$.content.[*].boMonId").value(hasItem(monHoc.getBoMonId().intValue())));
    }

    @AfterEach
    void tearDown() {
        monHocRepository.delete(monHoc);
    }
}