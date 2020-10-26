package com.andrzej.stream.invoice.simple;

import java.util.Objects;

public class SimpleProduct {

    private String productName;
    private double productPrice;

    public SimpleProduct(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleProduct that = (SimpleProduct) o;

        return Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return productName != null ? productName.hashCode() : 0;
    }
}

