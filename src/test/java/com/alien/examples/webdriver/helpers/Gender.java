package com.alien.examples.webdriver.helpers;

public enum Gender {

    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other"),
    PREFER_NOT_TO_SAY("Prefer not to say");

    private String value;

	Gender(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
