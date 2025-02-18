package org.example.model;


public class Product extends EntityByString{

    private Float price;
    private String origin;

    public Product(String name, Float price, String origin){
        super(name);
        this.price=price;
        this.origin=origin;
    }

    public String getOrigin(){return this.origin;}
    public Float getPrice(){return this.price;}

    public void setOrigin(String origin){this.origin=origin;}
    public void setPrice(Float price){this.price=price;}
}
