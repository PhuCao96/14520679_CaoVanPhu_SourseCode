package com.example.phucao.lab2_food;


public class Thumbnail {
    private String name;
    private int image;

    public Thumbnail() {
    }

    public Thumbnail(String name, int image) {
        this.name = name;
        this.image = image;
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
}
