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

    public List<Charakter> filterByOrigin(String origin) {
        List<Charakter> charakters = new ArrayList<>();
        for (Charakter charakter : CharakterRepo.getAll())
            if (charakter.getOrigin().equals(origin))
                charakters.add(charakter);
        return charakters;
    }
}