package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.MonHocDauDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MdDdRepository extends JpaRepository<MonHocDauDiem, Long> {
    List<MonHocDauDiem> findAllByMonHocId(Long mhId);
    List<MonHocDauDiem> findAllByDauDiemIdAndMonHocId(Long ddId, Long mhId);
}
