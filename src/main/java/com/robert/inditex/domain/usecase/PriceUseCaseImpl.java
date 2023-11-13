package com.robert.inditex.domain.usecase;

import com.robert.inditex.domain.model.Price;

import com.robert.inditex.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceUseCaseImpl implements PriceUseCase{

    private final PriceRepository priceRepository;

    @Autowired
    public PriceUseCaseImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
        return priceRepository.getPrice(applicationDate, productId, brandId);
    }
}
