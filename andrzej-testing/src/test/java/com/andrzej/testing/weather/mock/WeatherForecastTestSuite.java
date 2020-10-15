package com.andrzej.testing.weather.mock;

import com.andrzej.testing.weather.stub.Temperatures;
import com.andrzej.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {

    @Test
    public void testCalculateForecastWithMock() {
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        Map<Integer,Double> tempMock = new HashMap<>();
        tempMock.put(0,21.0);
        tempMock.put(1,18.2);
        tempMock.put(2,23.0);
        tempMock.put(3,12.3);
        tempMock.put(4,19.0);
        when(temperaturesMock.getTemperatures()).thenReturn(tempMock);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors =
                weatherForecast.calculateForecast().size();
        //Then
        Assert.assertEquals(5,quantityOfSensors);
    }
}
