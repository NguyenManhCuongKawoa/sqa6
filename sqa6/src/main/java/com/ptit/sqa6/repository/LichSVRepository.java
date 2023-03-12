package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.LichSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichSVRepository extends JpaRepository<LichSV, Long> {
    List<LichSV> findAllBySvId(Long svId);
    List<LichSV> findAllByLichId(Long lichId);
}
