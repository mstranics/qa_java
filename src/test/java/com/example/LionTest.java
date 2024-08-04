package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.Mockito;

import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Before
    public void setUp() {
        lion = new Lion(feline);
    }

    @Spy
    Feline feline;
    private Lion lion;


    @Test
    public void getKittensReturnsCorrectValue()  {

        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedGetKittens = 1;
        int actualGetKittens = lion.getKittens();
        assertEquals(expectedGetKittens, actualGetKittens);
    }

    @Test
    public void getFoodReturnsCorrectValue() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = lion.getFood();
        assertEquals(expectedFoodList, actualFoodList);
    }

    @Test
    public void incorrectValueInSexReturnsException()  {

        Exception ex = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("несуществующий пол");

        });
        assertEquals(ex.getMessage(), "Используйте допустимые значения пола животного - самей или самка");
    }
}
