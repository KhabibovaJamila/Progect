package com.example.mysmartlab.DataClass;

public class Product {
    private int id;
    private String name;
    private String  description;
    private int  price;
    private  String  category;
    private  String  time_result;
    private  String  preparation;
    private  String bio;

    public Product(int id, String name, String description, int price, String category, String time_result, String preparation, String bio) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.time_result = time_result;
        this.preparation = preparation;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime_result() {
        return time_result;
    }

    public void setTime_result(String time_result) {
        this.time_result = time_result;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
