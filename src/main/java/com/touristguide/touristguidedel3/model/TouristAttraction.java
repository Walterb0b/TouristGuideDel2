package com.touristguide.touristguidedel3.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private Long id;
    private String name;
    private String description;
    private City city;
    private List<Tag> tags = new ArrayList<>();
    private BigDecimal price;

    public TouristAttraction(String name, String description, City city, List<Tag> tags, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
        this.price = price;
    }

    public TouristAttraction(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
