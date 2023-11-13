package com.robert.inditex.domain.usecase;

import com.robert.inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceUseCase {

    Price getPrice(LocalDateTime applicationDate, Long productId, Long brandId);

}
