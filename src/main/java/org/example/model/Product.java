package org.example.model;


public class Product extends EntityByString{

    private Double price;
    private String origin;

    public Product(String name, Double price, String origin){
        super(name);
        this.price=price;
        this.origin=origin;
    }

    public String getOrigin(){return this.origin;}
    public Double getPrice(){return this.price;}

    public void setOrigin(String origin){this.origin=origin;}
    public void setPrice(Double price){this.price=price;}
}
