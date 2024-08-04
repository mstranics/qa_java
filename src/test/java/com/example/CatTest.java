package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test

    public void getFoodReturnsCorrectList() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = cat.getFood();
        assertEquals(expectedFoodList, actualFoodList);
    }

    @Test
    public void getSoundReturnsCorrectSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals("издаваемый звук не совпадает",expectedSound, actualSound);
    }

}
