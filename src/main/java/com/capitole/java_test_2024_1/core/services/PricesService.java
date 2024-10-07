package com.capitole.java_test_2024_1.core.services;

import com.capitole.java_test_2024_1.adapters.repositories.PricesRepository;
import com.capitole.java_test_2024_1.core.models.Brand;
import com.capitole.java_test_2024_1.core.models.Price;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class PricesService {
    private final PricesRepository pricesRepository;

    public PricesService(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    public Price findPrices(ZonedDateTime dateTime, Long productId, Long brandId) {
        return pricesRepository.findFirstByProductIdAndBrandAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                productId, new Brand(brandId), dateTime, dateTime
        );
    }
}
