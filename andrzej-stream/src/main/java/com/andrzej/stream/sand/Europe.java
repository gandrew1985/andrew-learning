package com.andrzej.stream.sand;

import java.math.BigDecimal;

public class Europe implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("300");
        return sandQuantity;
    }
}
