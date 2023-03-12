package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.DauDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DauDiemRepository extends JpaRepository<DauDiem, Long> {
}
