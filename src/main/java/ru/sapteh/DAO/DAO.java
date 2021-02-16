package ru.sapteh.DAO;

import java.util.List;

public interface DAO<Entity,Key> {
    void create(Entity entity);
    void update(Entity entity);
    List<Entity> readAllBy();
    void delete(Entity entity);
    Entity read(Key key);
}
