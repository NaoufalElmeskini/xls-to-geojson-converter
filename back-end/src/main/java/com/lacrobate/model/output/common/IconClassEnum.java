package com.lacrobate.model.output.common;

import org.apache.commons.lang3.RandomUtils;

public enum IconClassEnum {
    DROP;

    /**
     *
     * @return returns DROP or null, with a 50% probability each
     */
    public static String getRandomIconClass() {
        int i = RandomUtils.nextInt(0, 2);
        if (i == 0) {
            return DROP.name();
        }
        return null;
    }
}
