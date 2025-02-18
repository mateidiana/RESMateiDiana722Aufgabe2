package org.example;

import org.example.model.*;
import org.example.controller.*;
import org.example.repo.IRepositoryString;
import org.example.repo.InMemoryRepositoryString;
import org.example.view.*;
import org.example.repo.IRepository;
import org.example.repo.InMemoryRepository;


public class Main {
    public  static void main(String[] args){

        IRepositoryString<Product> productRepo=new InMemoryRepositoryString<>();
        IRepository<Charakter> clientRepo=new InMemoryRepository<>();

        Charakter charakter=new Charakter(1,"ch1","org1");
        Product product=new Product("Kunai",75.0F,"Konoha");
        clientRepo.create(charakter);
        productRepo.create(product);




        CharakterController clientController=new CharakterController(clientRepo);
        ProductController productController=new ProductController(productRepo);



        //clientController.buyProduct(charakter.getId(),product);



        View view=new View(productController,clientController);
        view.start();

    }
}
