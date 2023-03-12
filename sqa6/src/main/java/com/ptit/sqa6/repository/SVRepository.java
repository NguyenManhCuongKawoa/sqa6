package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SVRepository extends JpaRepository<SinhVien, Long> {
}
