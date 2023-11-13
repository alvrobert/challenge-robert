package com.robert.inditex.presentation;

import com.robert.inditex.domain.model.Price;
import com.robert.inditex.domain.usecase.PriceUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Api(value = "Price management")
@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceUseCase priceUseCase;

    @Autowired
    public PriceController(PriceUseCase priceUseCase) {
        this.priceUseCase = priceUseCase;
    }


    @ApiOperation(value = "View a list of avalible prices", response = Price.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrived list"),
            @ApiResponse(code = 401, message = "You are not authorized to view te resource"),
            @ApiResponse(code= 403, message = "Accessing the resource you were trying to reach forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/price")
    public ResponseEntity<Price> getPrice(
            @RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        return new ResponseEntity<>(priceUseCase.getPrice(applicationDate, productId, brandId), HttpStatus.OK);
    }
}
