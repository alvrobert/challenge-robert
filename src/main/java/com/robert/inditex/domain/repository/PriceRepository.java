package com.robert.inditex.domain.repository;

import com.robert.inditex.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceRepository {

    Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId);

}
