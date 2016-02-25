package com.br.lp3.dao;

import java.util.List;

/**
 * DAO Generico
 * @param <E> entidade
 * @author 31448471
 */
public interface GenericDAO <E>{
    public boolean create(E e);
    public List<E> readAll();
    public E readById(long id);
    public boolean update(E e);
    public boolean delete(E e);
}
