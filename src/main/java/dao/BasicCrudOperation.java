package dao;

import model.entity.Entity;

import java.util.List;

public interface BasicCrudOperation<K, E extends Entity> {

    List<E> findAll();

    boolean remove(long id);

    boolean remove(E e);

    boolean add(E e);
}
