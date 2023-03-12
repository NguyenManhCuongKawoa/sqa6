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
//		sv1.setEmail("gv2@pellcop.com");
//		sv1.setPhone("0978481376");
//		sv1.setUsername("cuongnm");
//		sv1.setPassword("cuongnm");
//		svRepository.save(sv1);
	}

	public static void main(String[] args) {
		SpringApplication.run(Sqa6Application.class, args);
	}

}
