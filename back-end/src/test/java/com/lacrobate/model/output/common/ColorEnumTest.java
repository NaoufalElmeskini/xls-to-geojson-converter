package com.lacrobate.model.output.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
class ColorEnumTest {

    @Test
    public void getRandomColorShouldBeValidInRandomBoundaries() {
        try {
            int colorEnumLength = ColorEnum.values().length;
            for (int i = 0; i < 1000; i++) {
                String randomColor = ColorEnum.getRandomColor();
                System.out.println(randomColor);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            fail("failed because of ArrayIndexOutOfBoundsException");
        }
    }

}