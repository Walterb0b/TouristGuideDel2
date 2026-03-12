package com.touristguide.touristguidedel3.model;

public enum Tag {
    KID_FRIENDLY("Børnevenlig"),
    FREE("Gratis"),
    RESTAURANT("Restaurant"),
    MUSEUM("Museum"),
    ENTERTAINMENT("Underholdning"),
    HISTORY("Historie");

    private final String name;

    Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
