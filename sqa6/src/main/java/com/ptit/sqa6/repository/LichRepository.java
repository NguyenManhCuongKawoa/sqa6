package com.ptit.sqa6.repository;

import com.ptit.sqa6.model.Lich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichRepository extends JpaRepository<Lich, Long> {

    Page<Lich> findAllByGvId(Long teacherId, Pageable pageable);
}
