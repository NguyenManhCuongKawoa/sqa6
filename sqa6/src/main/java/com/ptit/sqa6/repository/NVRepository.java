package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.NhanVien;
import com.ptit.sqa6.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NVRepository extends JpaRepository<NhanVien, Long> {
    Optional<NhanVien> findByUsernameAndPassword(String username, String password);
}
