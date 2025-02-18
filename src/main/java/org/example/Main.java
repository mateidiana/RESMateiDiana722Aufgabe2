package org.example;

import org.example.model.*;
import org.example.controller.*;
import org.example.repo.IRepositoryString;
import org.example.repo.InMemoryRepositoryString;
import org.example.view.*;
import org.example.repo.IRepository;
import org.example.repo.InMemoryRepository;

import java.awt.color.ProfileDataException;


public class Main {
    public  static void main(String[] args){

        IRepositoryString<Product> productRepo=new InMemoryRepositoryString<>();
        IRepository<Charakter> clientRepo=new InMemoryRepository<>();


        Charakter c1 = new Charakter(1, "Naruto Uzumaki", "Konoha");
        Charakter c2 = new Charakter(2, "Gaara", "Sunagakure");
        Charakter c3 = new Charakter(3, "Kisame Hoshigaki", "Kirigakure");
        Charakter c4 = new Charakter(4, "Deidara", "Iwagakure");
        Charakter c5 = new Charakter(5, "Itachi Uchiha", "Konoha");


        Product product=new Product("Kunai",50.0,"Konoha");
        Product prod1=new Product("Shuriken", 30.0, "Konoha");
        Product prod2=new Product("Schwert", 200.0, "Kirigakure");
        Product prod3=new Product("Heiltrank", 100.0, "Sunagakure");
        Product prod4=new Product("Sprengsiegel", 75.0, "Iwagakure");
        Product prod5= new Product("Riesenfächer", 300.0, "Sunagakure");
        Product prod6=new Product("Giftklinge", 150.0, "Kirigakure");
        Product prod7=new Product("Explosionskugel", 250.0, "Iwagakure");
        Product prod8=new Product("Schattendolch", 180.0, "Konoha");
        Product prod9=new Product("Wasserperle", 90.0, "Kirigakure");




        clientRepo.create(c1);
        clientRepo.create(c2);
        clientRepo.create(c3);
        clientRepo.create(c4);
        clientRepo.create(c5);


        productRepo.create(product);
        productRepo.create(prod1);
        productRepo.create(prod2);
        productRepo.create(prod3);
        productRepo.create(prod4);
        productRepo.create(prod5);
        productRepo.create(prod6);
        productRepo.create(prod7);
        productRepo.create(prod8);
        productRepo.create(prod9);




        CharakterController clientController=new CharakterController(clientRepo);
        ProductController productController=new ProductController(productRepo);



        clientController.buyProduct(1,product);
        clientController.buyProduct(1,prod3);
        clientController.buyProduct(1,prod8);
        clientController.buyProduct(1,prod5);



        clientController.buyProduct(2,prod2);
        clientController.buyProduct(2,prod4);
        clientController.buyProduct(2,prod6);
        clientController.buyProduct(2,prod1);



        clientController.buyProduct(3,prod1);
        clientController.buyProduct(3,prod2);
        clientController.buyProduct(3,prod3);
        clientController.buyProduct(3,prod7);
        clientController.buyProduct(3,prod9);


        clientController.buyProduct(4,product);
        clientController.buyProduct(4,prod4);
        clientController.buyProduct(4,prod7);
        clientController.buyProduct(4,prod9);


        clientController.buyProduct(5,prod8);
        clientController.buyProduct(5,prod6);
        clientController.buyProduct(5,prod2);
        clientController.buyProduct(5,prod7);

        View view=new View(productController,clientController);
        view.start();

    }
}
