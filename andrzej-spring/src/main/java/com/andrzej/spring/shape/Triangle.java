package com.andrzej.spring.shape;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape{
    @Override
    public String getShapeName() {
        return "triangle";
    }
}
