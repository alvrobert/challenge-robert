package com.robert.inditex;

import com.robert.inditex.domain.exception.PriceNotFoundException;
import com.robert.inditex.domain.model.Price;
import com.robert.inditex.domain.repository.PriceRepository;
import com.robert.inditex.domain.usecase.PriceUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceUseCaseImpl priceService;


    @Test
    public void testGetPriceAtSpecificTime() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 6, 14, 10, 0);
        long productId = 35455;
        long brandId = 1;

        Price expectedPrice = Price.builder()
                .id(1L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2023, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priceList(1)
                .productId(35455L)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .currency("EUR")
                .build();

        when(priceRepository.getPrice(dateTime, productId, brandId))
                .thenReturn(expectedPrice);

        Optional<Price> result = Optional.ofNullable(priceService.getPrice(dateTime, productId, brandId));

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(expectedPrice);
    }

    @Test
    void testGetPriceAtSpecificTimse() {
        // Arrange
        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 16, 0); // Cambiado a las 16:00
        long brandId = 1;
        long productId = 35455;
        Price expectedPrice = Price.builder()
                .id(1L)
                .brandId(1L)
                .startDate(LocalDateTime.of(2023, 6, 14, 0, 0))
                .endDate(LocalDateTime.of(2023, 12, 31, 23, 59, 59))
                .priceList(1)
                .productId(35455L)
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .currency("EUR")
                .build();

        when(priceRepository.getPrice(requestTime, brandId, productId))
                .thenReturn(expectedPrice);

        Price actualPrice = priceService.getPrice(requestTime, brandId, productId);

        assertNotNull(actualPrice);
        assertEquals(expectedPrice, actualPrice);

        verify(priceRepository, times(1))
                .getPrice(requestTime, brandId, productId);
    }

    @Test
    void testGetPriceAtSpecificTimeNotFound() {

        LocalDateTime requestTime = LocalDateTime.of(2020, 6, 14, 16, 0); // Cambiado a las 16:00
        long brandId = 1;
        long productId = 35455;

        when(priceRepository.getPrice(any(), anyLong(), anyLong()))
                .thenThrow(new RuntimeException("Simulando una excepción en el repositorio"));

        assertThrows(PriceNotFoundException.class, () -> {
            priceService.getPrice(requestTime, brandId, productId);
        });

        verify(priceRepository, times(1))
                .getPrice(requestTime, brandId, productId);
    }

}
