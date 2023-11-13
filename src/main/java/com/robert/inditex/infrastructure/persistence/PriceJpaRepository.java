package com.robert.inditex.infrastructure.persistence;

import com.robert.inditex.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<Price, Long> {
    Price findFirstByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}
