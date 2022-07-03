package org.nataliya;

public enum Gender {
    MALE("homme"),
    FEMALE("femme");
    public final String desc;
    Gender(String desc) {
        this.desc = desc;
    }
}
