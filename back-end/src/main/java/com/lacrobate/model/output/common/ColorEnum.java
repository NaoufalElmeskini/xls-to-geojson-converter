package com.lacrobate.model.output.common;

import org.apache.commons.lang3.RandomUtils;

public enum ColorEnum {
    DarkBlue;
//    DarkRed, DarkBlue, Blue, GoldenRod, DarkGreen, DeepSkyBlue, Indigo, YellowGreen, IndianRed, Purple, Chocolate, Salmon;

    public static String getRandomColor() {
        int i = RandomUtils.nextInt(0, ColorEnum.values().length);
        return ColorEnum.values()[i].name();
    }
}
