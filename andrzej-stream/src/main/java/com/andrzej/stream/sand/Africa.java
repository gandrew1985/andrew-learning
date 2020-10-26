package com.andrzej.stream.sand;

import java.math.BigDecimal;

public class Africa implements SandStorage{
    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal africaSands = new BigDecimal("400");
        return africaSands;
    }
}
