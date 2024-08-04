package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {




    public LionParametrizedTest(String sex, Boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    private final String sex;
private final Boolean expected;

    @Parameterized.Parameters
    public static Object[][] getManeData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

@Test
public void hasManeReturnsCorrectValue() throws Exception {
    Lion lion = new Lion(sex);
    boolean actualHasMane=lion.doesHaveMane();
    assertEquals(expected,actualHasMane);
}


}
