package com.capitole.java_test_2024_1.adapters.controllers;

import com.capitole.java_test_2024_1.core.models.Price;
import com.capitole.java_test_2024_1.core.services.PricesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("prices")
public class PricesController {
    private final PricesService pricesService;

    public PricesController(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping(value = "/{productId}/{brandId}/{dateTime}", produces = "application/json")
    public Price getPrice(
            @PathVariable Long productId,
            @PathVariable Long brandId,
            @PathVariable ZonedDateTime dateTime
    ) {
        Price resul = pricesService.findPrices(dateTime, productId, brandId);
        if(resul == null) throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Price not found"
        );
        return resul;
    }
}
