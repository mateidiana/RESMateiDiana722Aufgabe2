package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Charakter extends Entity {
    private String name;
    private String origin;
    List<Product> products;

    public Charakter(int id, String name, String origin){
        super(id);
        this.name=name;
        this.origin=origin;
        this.products=new ArrayList<>();
    }

    public String getName(){return this.name;}
    public String getOrigin(){return this.origin;}
    public void setName(String name){this.name=name;}
    public void setOrigin(String origin){this.origin=origin;}

    public void setProducts(List<Product> products){this.products=products;}
    public List<Product> getProducts(){return this.products;}

}
