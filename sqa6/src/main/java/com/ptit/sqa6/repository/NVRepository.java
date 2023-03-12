package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NVRepository extends JpaRepository<NhanVien, Long> {
}
