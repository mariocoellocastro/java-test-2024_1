package com.capitole.java_test_2024_1.core.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.Objects;

@Entity(name = "PRICES")
@IdClass(PriceId.class)
public class Price {
    @Id
    private Long productId;
    @Id
    private Long priceList;
    private Integer priority;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Brand brand;

    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    private Double price;
    private String curr;

    public Price() {
    }

    public Price(Long productId, Long priceList, Integer priority, Brand brand, ZonedDateTime startDate, ZonedDateTime endDate, Double price, String curr) {
        this.productId = productId;
        this.priceList = priceList;
        this.priority = priority;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.curr = curr;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(productId, price1.productId) && Objects.equals(brand, price1.brand) && Objects.equals(startDate, price1.startDate) && Objects.equals(endDate, price1.endDate) && Objects.equals(priceList, price1.priceList) && Objects.equals(priority, price1.priority) && Objects.equals(price, price1.price) && Objects.equals(curr, price1.curr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brand, startDate, endDate, priceList, priority, price, curr);
    }

    @Override
    public String toString() {
        return "Price{" +
                "productId=" + productId +
                ", brand=" + brand +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", priority=" + priority +
                ", price=" + price +
                ", curr='" + curr + '\'' +
                '}';
    }
}
