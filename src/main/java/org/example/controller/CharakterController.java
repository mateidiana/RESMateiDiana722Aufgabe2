package org.example.controller;

import org.example.model.*;
import org.example.repo.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class CharakterController {
    private final IRepository<Charakter> CharakterRepo;

    public CharakterController(IRepository<Charakter> CharakterRepo) {
        this.CharakterRepo = CharakterRepo;
    }

    public boolean createCharakter(int id, String name, String origin) {
        for (Charakter Charakter : CharakterRepo.getAll())
            if (Charakter.getId() == id)
                return false;
        Charakter Charakter = new Charakter(id, name, origin);
        CharakterRepo.create(Charakter);
        return true;
    }

    public boolean deleteCharakter(int id) {
        for (Charakter Charakter : CharakterRepo.getAll())
            if (Charakter.getId() == id) {
                CharakterRepo.delete(id);
                return true;
            }
        return false;

    }

    public boolean updateCharakter(int id, String name, String origin) {
        for (Charakter Charakter : CharakterRepo.getAll())
            if (Charakter.getId() == id) {
                Charakter.setName(name);
                Charakter.setOrigin(origin);
                CharakterRepo.update(Charakter);
                return true;
            }
        return false;
    }

    public Charakter getCharakterById(int id) {
        return CharakterRepo.read(id);
    }

    public Charakter getCharakterByName(String id) {
        for (Charakter ch:CharakterRepo.getAll())
            if (ch.getName().equals(id))
                return ch;
        return null;
    }

    public List<Charakter> filterByOrigin(String origin) {
        List<Charakter> charakters = new ArrayList<>();
        for (Charakter charakter : CharakterRepo.getAll())
            if (charakter.getOrigin().equals(origin))
                charakters.add(charakter);
        return charakters;
    }

    public void buyProduct(int charakterId, Product product){
        Charakter client=getCharakterById(charakterId);
        List<Product> products=client.getProducts();
        products.add(product);
        client.setProducts(products);
        CharakterRepo.update(client);
    }

    public List<Charakter> filterByProductAndOrigin(String origin){
        List<Charakter> clients=new ArrayList<>();
        for(Charakter client:CharakterRepo.getAll())
            for (Product product:client.getProducts())
                if(product.getOrigin().equals(origin)){
                    clients.add(client);
                    break;
                }
        sortStringsAscending(clients);
        return clients;
    }

    public static void sortStringsAscending(List<Charakter> strings) {
        int n = strings.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareStrings(strings.get(j).getName(), strings.get(j + 1).getName()) > 0) {
                    Charakter temp = strings.get(j);
                    strings.set(j, strings.get(j + 1));
                    strings.set(j + 1, temp);
                }
            }
        }
    }

    public static int compareStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return len1 - len2;
    }

    public List<Product> sortProductsAscending(Charakter charakter){
        //Charakter client=getCharakterById(charakterId);
        List<Product> products=charakter.getProducts();
        products.sort(Comparator.comparingDouble(Product::getPrice));
        return products;
    }

    public List<Product> sortProductsDescending(Charakter charakter){
        //Charakter client=getCharakterById(clientId);
        List<Product> products=charakter.getProducts();
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        return products;
    }
}