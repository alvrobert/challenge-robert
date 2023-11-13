package com.robert.inditex.infrastructure.persistence;

import com.robert.inditex.domain.model.Price;
import com.robert.inditex.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;

    @Autowired
    public PriceRepositoryImpl(PriceJpaRepository priceJpaRepository) {
        this.priceJpaRepository = priceJpaRepository;
    }

    @Override
    public Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceJpaRepository.findFirstByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                brandId, productId, applicationDate, applicationDate);
    }
}
