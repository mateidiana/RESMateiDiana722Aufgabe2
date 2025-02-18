package org.example.controller;

import org.example.model.*;
import org.example.repo.IRepository;
import org.example.repo.IRepositoryString;

import java.util.ArrayList;
import java.util.List;
public class ProductController {
    private final IRepositoryString<Product> productRepo;
    public ProductController(IRepositoryString<Product> productRepo){this.productRepo=productRepo;}

    public boolean createProduct(String name, Double price, String origin){
        for (Product product:productRepo.getAll())
            if (product.getId().equals(name))
                return false;
        Product product=new Product(name,price,origin);
        productRepo.create(product);
        return true;
    }

    public boolean deleteProduct(String id){
        for (Product product:productRepo.getAll())
            if(product.getId().equals(id)){
                productRepo.delete(id);
                return true;
            }
        return false;

    }

    public boolean updateProduct(String name, Double price, String origin){
        for (Product product:productRepo.getAll())
            if (product.getId().equals(name))
            {
                product.setId(name);
                product.setPrice(price);
                product.setOrigin(origin);
                productRepo.update(product);
                return true;
            }
        return false;
    }

    public Product getProductById(String id){
        return productRepo.read(id);
    }
}

