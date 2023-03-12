package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.DiemSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiemSVRepository extends JpaRepository<DiemSV, Long> {
    Optional<DiemSV> findBySvIdAndMonHocDauDiemId(Long svId, Long mhddId);
}
