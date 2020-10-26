package com.andrzej.stream.invoice.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleInvoice {

    private List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(SimpleItem item) {
        return removeItem(item);
    }

    public List<SimpleItem> getItems() {
        return items;
    }

    public double getValueToPay() {
        return items.stream()
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
