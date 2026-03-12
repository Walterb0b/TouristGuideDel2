package com.touristguide.touristguidedel3.model;

import java.nio.charset.StandardCharsets;

public enum City {
    COPENHAGEN("København"),
    AARHUS("Aarhus"),
    ODENSE("Odense"),
    AALBORG("Aalborg"),
    ESBJERG("Esbjerg"),
    RANDERS("Randers"),
    KOLDING("Kolding"),
    VEJLE("Vejle"),
    HORSENS("Horsens"),
    ROSKILDE("Roskilde"),
    HERNING("Herning"),
    SILKEBORG("Silkeborg"),
    NAESTVED("Næstved"),
    SLAGELSE("Slagelse"),
    HOLBAEK("Holbæk"),
    HILLEROED("Hillerød"),
    SOENDERBORG("Sønderborg"),
    SVENDBORG("Svendborg"),
    FREDERICIA("Fredericia"),
    HELSINGOER("Helsingør"),
    BILLUND("Billund");

    private final String displayName;

    City(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static City fromDb(String dbName) {
        if (dbName == null) {
            throw new IllegalArgumentException("City value from DB is null");
        }

        // Trim og ignore case
        for (City c : values()) {
            if (c.name().equalsIgnoreCase(dbName.trim())) {
                return c;
            }
        }
        throw new IllegalArgumentException("Unknown city: " + dbName);
    }
}
