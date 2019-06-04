package com.example.assignment5;

public class ModelPhone {
    private  int image ;
    private  String name,text,price;

    public ModelPhone(int image, String name, String text, String price) {
        this.image = image;
        this.name = name;
        this.text = text;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
