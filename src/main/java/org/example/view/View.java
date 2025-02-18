package org.example.view;
import org.example.controller.*;
import org.example.model.*;


import java.util.List;
import java.util.Scanner;
public class View {
    private ProductController ProductController;
    private CharakterController CharakterController;
    public View(ProductController ProductController, CharakterController CharakterController){
        this.ProductController=ProductController;
        this.CharakterController=CharakterController;}

    public void start(){
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Select an option: \n1. Add Product\n2. Delete Product\n3. Update Product\n4. Get Product by id\n5. Add Charakter\n6. Delete Charakter\n7. Update Charakter\n8. Get Charakter by id\n9. Filter Charakters by origin\n10. Buy Product\n11. Filter Charakters by Product of Origin \n12. Sort Products of Charakter\n13. Exit");
            String option = scanner.nextLine();

            switch(option){
                case "1":
                    //int id=readProductId(scanner);
                    String name=readProductName(scanner);
                    String origin=readProductOrigin(scanner);
                    Double price=readProductPrice(scanner);
                    if (ProductController.createProduct(name,price, origin))
                        System.out.println("Product added!");
                    else
                        System.out.println("Id in use!");
                    break;

                case "2":
                    String idDelete=readProductName(scanner);
                    if (ProductController.deleteProduct(idDelete))
                        System.out.println("Product deleted!");
                    else
                        System.out.println("Product not found!");
                    break;

                case "3":
                    //int idUpdate=readProductId(scanner);
                    String nameUpdate=readProductName(scanner);
                    String originUpdate=readProductOrigin(scanner);
                    Double priceUpdate=readProductPrice(scanner);

                    if (ProductController.updateProduct(nameUpdate,priceUpdate,originUpdate))
                        System.out.println("Product updated!");
                    else
                        System.out.println("Product not found!");
                    break;

                case "4":
                    String idFind=readProductName(scanner);
                    Product Product=ProductController.getProductById(idFind);
                    if (Product==null)
                        System.out.println("Product not found!");
                    else System.out.println(Product.getId()+" "+Product.getOrigin()+" "+ Product.getPrice());
                    break;

                case "5":
                    int idClient=readClientId(scanner);
                    String nameClient=readClientName(scanner);
                    String originClient=readClientOrigin(scanner);

                    if (CharakterController.createCharakter(idClient,nameClient,originClient))
                        System.out.println("Charakter added!");
                    else
                        System.out.println("Id in use!");
                    break;

                case "6":
                    int idDeleteClient=readClientId(scanner);
                    if (CharakterController.deleteCharakter(idDeleteClient))
                        System.out.println("Charakter deleted!");
                    else
                        System.out.println("Charakter not found!");
                    break;

                case "7":
                    int idClientUpdate=readClientId(scanner);
                    String nameClientUpdate=readClientName(scanner);
                    String originUpdate1=readClientOrigin(scanner);

                    if (CharakterController.updateCharakter(idClientUpdate,nameClientUpdate,originUpdate1))
                        System.out.println("Client updated!");
                    else
                        System.out.println("Charakter not found!");
                    break;

                case "8":
                    int idFindClient=readClientId(scanner);
                    Charakter client=CharakterController.getCharakterById(idFindClient);
                    if (client==null)
                        System.out.println("Charakter not found!");
                    else System.out.println(client.getId()+" "+client.getName()+" "+client.getOrigin());
                    break;

                case "9":
                    String findOrigin=readClientOrigin(scanner);
                    List<Charakter> findClients=CharakterController.filterByOrigin(findOrigin);
                    for (Charakter client1:findClients)
                        System.out.println(client1.getName());
                    break;

                case "10":
                    String idProduct=readProductName(scanner);
                    int idCharakter=readClientId(scanner);
                    Product product1=ProductController.getProductById(idProduct);
                    CharakterController.buyProduct(idCharakter,product1);
                    break;

                case "11":
                    String findOriginFilter=readProductOrigin(scanner);
                    List<Charakter> clients=CharakterController.filterByProductAndOrigin(findOriginFilter);
                    for (Charakter client1:clients)
                        System.out.println(client1.getName());
                    break;

                case "12":
//                    int choice=readChoiceId(scanner);
//                    if (choice==1){
//                        int clientId=readClientId(scanner);
//                        List<Product> products=CharakterController.sortProductsAscending(clientId);
//                        for (Product product2:products)
//                            System.out.println(product2.getName());
//                    }
//
//                    if (choice==2){
//                        int clientId=readClientId(scanner);
//                        List<Product> products=CharakterController.sortProductsDescending(clientId);
//                        for (Product product2:products)
//                            System.out.println(product2.getName());
//                    }

                    break;

                case "13":
                    continueLoop=false;
                    break;
            }
        }
    }

    private static int readProductId(Scanner scanner) {
        System.out.print("Enter Product ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readChoiceId(Scanner scanner) {
        System.out.print("Enter how the products are sorted.\nEnter 1 for sorting in ascending order\nEnter 2 for sorting descending order: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static int readClientId(Scanner scanner) {
        System.out.print("Enter Charakter ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String readProductName(Scanner scanner) {
        System.out.println("Enter Product name: ");
        return scanner.nextLine();
    }

    private static String readClientName(Scanner scanner) {
        System.out.println("Enter Charakter name: ");
        return scanner.nextLine();
    }


    private static String readClientOrigin(Scanner scanner) {
        System.out.println("Enter Charakter origin: ");
        return scanner.nextLine();
    }

    private static String readProductOrigin(Scanner scanner) {
        System.out.println("Enter Product origin: ");
        return scanner.nextLine();
    }

    private static Double readProductPrice(Scanner scanner) {
        System.out.print("Enter product price: ");
        return Double.parseDouble(scanner.nextLine());
    }
}
