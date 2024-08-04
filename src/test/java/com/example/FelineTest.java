package com.example;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline felineSpy;

    @Test
    public void eatMeatReturnCorrectList() throws Exception {
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = felineSpy.eatMeat();
        assertEquals(expectedFoodList, actualFoodList);
    }

    @Test
    public void getFamilyReturnCorrectValue()  {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensNoParamReturnCorrectValue() {
        Mockito.when(felineSpy.getKittens(1)).thenReturn(1);
        int expectedKittensNoParam = 1;
        int actualGetKittensNoParam = felineSpy.getKittens();
        assertEquals(expectedKittensNoParam, actualGetKittensNoParam);

    }

    @Test
    public void getKittensParamReturnCorrectValue() {
        Feline feline = new Feline();
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        int expectedKittensParam = randomNumber;
        int actualGetKittensParam = feline.getKittens(randomNumber);
        assertEquals(expectedKittensParam, actualGetKittensParam);

    }

}
