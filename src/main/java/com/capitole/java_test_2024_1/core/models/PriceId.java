package com.capitole.java_test_2024_1.core.models;

import java.io.Serializable;
import java.util.Objects;

public class PriceId implements Serializable {
    private Long productId;
    private Long priceList;

    public PriceId() {
    }

    public PriceId(Long productId, Long priceList) {
        this.productId = productId;
        this.priceList = priceList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceId priceId = (PriceId) o;
        return Objects.equals(productId, priceId.productId) && Objects.equals(priceList, priceId.priceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, priceList);
    }
}
