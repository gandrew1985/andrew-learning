package com.andrzej.stream.invoice.simple;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValueToPay() {
        //Given
        SimpleProduct milk = new SimpleProduct("Milk", 17.28);
        SimpleProduct meat = new SimpleProduct("Meat", 11.99);
        SimpleProduct water = new SimpleProduct("Water", 6.49);

        SimpleItem item1 = new SimpleItem(milk,2);
        SimpleItem item2 = new SimpleItem(meat,3.5);
        SimpleItem item4 = new SimpleItem(water,5);

        SimpleInvoice invoice = new SimpleInvoice();
        //When
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item4);
        //Then
        assertEquals(3,invoice.getItems().size());
        assertEquals(108.975, invoice.getValueToPay(),0.001);
    }



}