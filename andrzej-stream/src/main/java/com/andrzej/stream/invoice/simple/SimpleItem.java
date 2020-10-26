package com.andrzej.stream.invoice.simple;

public class SimpleItem {

    private SimpleProduct simpleProduct;
    private double quantity;

    public SimpleItem(SimpleProduct simpleProduct, double quantity) {
        this.simpleProduct = simpleProduct;
        this.quantity = quantity;
    }

    public SimpleProduct getSimpleProduct() {
        return simpleProduct;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getValue() {
        return quantity * simpleProduct.getProductPrice();
    }
}
