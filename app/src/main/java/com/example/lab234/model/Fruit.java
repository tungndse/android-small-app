package com.example.lab234.model;

public class Fruit {
    private String name;
    private int imageResource;
    private String description;

    public Fruit(String name, int imageResource, String description) {
        this.name = name;
        this.imageResource = imageResource;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }
}

