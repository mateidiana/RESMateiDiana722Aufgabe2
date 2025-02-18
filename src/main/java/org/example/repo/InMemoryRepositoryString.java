package org.example.repo;
import org.example.model.Entity;
import org.example.model.EntityByString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryRepositoryString<T extends EntityByString> implements IRepositoryString<T> {
    private final Map<String,T> data = new HashMap<>();

    @Override
    public void create(T obj) {
        data.putIfAbsent(obj.getId(), obj);
    }

    @Override
    public T read(String id) {
        return data.get(id);
    }

    @Override
    public void update(T obj) {
        data.replace(obj.getId(), obj);
    }

    @Override
    public void delete(String id) {
        data.remove(id);
    }

    @Override
    public List<T> getAll() {
        return data.values().stream().collect(Collectors.toList());
    }
}
