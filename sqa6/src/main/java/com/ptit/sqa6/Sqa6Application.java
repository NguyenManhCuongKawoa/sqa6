package com.ptit.sqa6;

import com.ptit.sqa6.model.NhanVien;
import com.ptit.sqa6.model.SinhVien;
import com.ptit.sqa6.repository.NVRepository;
import com.ptit.sqa6.repository.SVRepository;
import com.ptit.sqa6.utils.DBConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Sqa6Application {

	@Autowired
	private NVRepository nvRepository;

	@Autowired
	private SVRepository svRepository;


	@PostConstruct
	public void initApplication() {
//		NhanVien ql1 = new NhanVien();
//		ql1.setName("ql1");
//		ql1.setAddress("Vinh Phuc");
//		ql1.setBirthday("22/11/2001");
//		ql1.setVitri(DBConstants.POSITION_QL);
//		ql1.setEmail("gv1@pellcop.com");
//		ql1.setPhone("0978481376");
//		ql1.setUsername("ql1");
//		ql1.setPassword("ql1");
//		nvRepository.save(ql1);
//
//		NhanVien gv1 = new NhanVien();
//		gv1.setName("gv1");
//		gv1.setAddress("Vinh Phuc");
//		gv1.setBirthday("22/11/2001");
//		gv1.setVitri(DBConstants.POSITION_GV);
//		gv1.setEmail("gv1@pellcop.com");
//		gv1.setPhone("0978481376");
//		gv1.setUsername("gv1");
//		gv1.setPassword("gv1");
//		nvRepository.save(gv1);
//
//		NhanVien gv2 = new NhanVien();
//		gv2.setName("gv2");
//		gv2.setAddress("Ha Noi");
//		gv2.setBirthday("22/11/2001");
//		gv2.setVitri(DBConstants.POSITION_GV);
//		gv2.setEmail("gv2@pellcop.com");
//		gv2.setPhone("0123456789");
//		gv2.setUsername("gv2");
//		gv2.setPassword("gv2");
//		nvRepository.save(gv2);
//
//		SinhVien sv1 = new SinhVien();
//		sv1.setName("CuongNM");
//		sv1.setAddress("Vinh Phuc");
//		sv1.setBirthday("22/11/2001");
//		sv1.setMasv("B19DCCN083");
//		sv1.setEmail("cuongnm@pellcop.com");
//		sv1.setPhone("0978481376");
//		sv1.setUsername("cuongnm");
//		sv1.setPassword("cuongnm");
//		svRepository.save(sv1);
//
//		SinhVien sv2 = new SinhVien();
//		sv2.setName("Sinh Viên 2");
//		sv2.setAddress("Ứng Hòa, Hà Nội");
//		sv2.setBirthday("22/11/2001");
//		sv2.setMasv("B19DCCN222");
//		sv2.setEmail("sv2@pellcop.com");
//		sv2.setPhone("0978481376");
//		sv2.setUsername("sv2");
//		sv2.setPassword("sv2");
//		svRepository.save(sv2);
//
//		SinhVien sv3 = new SinhVien();
//		sv3.setName("Sinh Viên 3");
//		sv3.setAddress("Vinh Phuc");
//		sv3.setBirthday("22/11/2001");
//		sv3.setMasv("B19DCCN333");
//		sv3.setEmail("sv3@pellcop.com");
//		sv3.setPhone("0978481376");
//		sv3.setUsername("sv3");
//		sv3.setPassword("sv3");
//		svRepository.save(sv3);
//
//		SinhVien sv4 = new SinhVien();
//		sv4.setName("Sinh Viên 4");
//		sv4.setAddress("Vinh Phuc");
//		sv4.setBirthday("22/11/2001");
//		sv4.setMasv("B19DCCN444");
//		sv4.setEmail("sv4@pellcop.com");
//		sv4.setPhone("0978481376");
//		sv4.setUsername("sv4");
//		sv4.setPassword("sv4");
//		svRepository.save(sv4);
//
//		SinhVien sv5 = new SinhVien();
//		sv5.setName("Sinh Viên 5");
//		sv5.setAddress("Vinh Phuc");
//		sv5.setBirthday("22/11/2001");
//		sv5.setMasv("B19DCCN555");
//		sv5.setEmail("sv5@pellcop.com");
//		sv5.setPhone("0978481376");
//		sv5.setUsername("sv5");
//		sv5.setPassword("sv5");
//		svRepository.save(sv5);
	}

	public static void main(String[] args) {
		SpringApplication.run(Sqa6Application.class, args);
	}

}
