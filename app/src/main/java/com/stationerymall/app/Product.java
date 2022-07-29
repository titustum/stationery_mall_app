package com.stationerymall.app;

public class Product {


    String category;
    String name;
    int image;
    int price;

    public String getCategory() {
        return category;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(String category, String name, int image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.category = category;
    }


}
