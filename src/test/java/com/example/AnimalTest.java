package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    @Test
    public void getFamilyReturnsCorrectValue() {
        Animal animal = new Animal();
        String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualFamily = animal.getFamily();
        assertEquals("возвращаемый текст не совпадает", expectedFamily, actualFamily);
    }

    @Test
    public void IncorrectAnimalTypeReturnsException() {
        Exception ex = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("всеядное");
        });
        assertEquals("возвращаемый текст ошибки не совпадает", "Неизвестный вид животного, используйте значение Травоядное или Хищник", ex.getMessage());
    }
}
