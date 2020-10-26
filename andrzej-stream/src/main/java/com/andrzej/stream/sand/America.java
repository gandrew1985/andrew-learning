package com.andrzej.stream.sand;

import java.math.BigDecimal;

public class America implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal americaSands = new BigDecimal("500");
        return americaSands;
    }
}
