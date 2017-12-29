package com.example.phucao.lab2_food;


public class Dish {
    private String name;
    private int image;
    private boolean promotion;

    public Dish() {
    }

    public Dish(String name, int image, boolean promotion) {
        this.name = name;
        this.image = image;
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
