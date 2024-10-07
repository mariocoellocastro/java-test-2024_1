package com.capitole.java_test_2024_1.adapters.repositories;

import com.capitole.java_test_2024_1.core.models.Brand;
import com.capitole.java_test_2024_1.core.models.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;

@Repository
public interface PricesRepository extends CrudRepository<Price, Long> {
    Price findFirstByProductIdAndBrandAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long productId, Brand brand, ZonedDateTime dateTime1, ZonedDateTime dateTime2
    );
}
