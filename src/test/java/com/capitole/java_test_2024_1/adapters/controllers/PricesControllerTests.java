package com.capitole.java_test_2024_1.adapters.controllers;

import com.capitole.java_test_2024_1.adapters.repositories.PricesRepository;
import com.capitole.java_test_2024_1.core.services.PricesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PricesControllerTests {
    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private PricesService pricesService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void runTests() throws Exception {
        //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        final String TEST_1 = "/prices/35455/1/2020-06-14T10:00:00.000+00:00";
        final int PRICE_LIST_1 = 1;
        //Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        final String TEST_2 = "/prices/35455/1/2020-06-14T16:00:00.000+00:00";
        final int PRICE_LIST_2 = 2;
        //Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        final String TEST_3 = "/prices/35455/1/2020-06-14T21:00:00.000+00:00";
        final int PRICE_LIST_3 = 1;
        //Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        final String TEST_4 = "/prices/35455/1/2020-06-15T10:00:00.000+00:00";
        final int PRICE_LIST_4 = 3;
        //Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        final String TEST_5 = "/prices/35455/1/2020-06-16T21:00:00.000+00:00";
        final int PRICE_LIST_5 = 4;

        mockMvc.perform(get(TEST_1)).andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(PRICE_LIST_1))
                .andDo(print());
        mockMvc.perform(get(TEST_2)).andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(PRICE_LIST_2))
                .andDo(print());
        mockMvc.perform(get(TEST_3)).andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(PRICE_LIST_3))
                .andDo(print());
        mockMvc.perform(get(TEST_4)).andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(PRICE_LIST_4))
                .andDo(print());
        mockMvc.perform(get(TEST_5)).andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(PRICE_LIST_5))
                .andDo(print());
    }
}
