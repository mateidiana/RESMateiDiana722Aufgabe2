package org.example.repo;
import org.example.model.Entity;
import org.example.model.EntityByString;

import java.util.List;

public interface IRepositoryString<T extends EntityByString> {

    public void create(T obj);

    public T read(String id);

    public void update(T obj);

    public void delete(String id);

    public List<T> getAll();
}


