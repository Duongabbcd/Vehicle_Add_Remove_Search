package com.example.vehicle_add_remove_search.Model;

public class Product {
    private int image ;
    private String publisher ,name;
    private int price ;
    private String subscription ;

    public Product() {
    }

    public Product(int image, String publisher, String name, int price, String subscription) {
        this.image = image;
        this.publisher = publisher;
        this.name = name;
        this.price = price;
        this.subscription = subscription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }
}
