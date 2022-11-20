package Persistancy;

import java.util.ArrayList;

import Exception.*;
public interface Persistancy<E> {
    public void addEntity(E entity) throws NoIdenticEntitiesException;

    public E deleteEntity(int id);

    public void updateEntity(int id, E entity) throws NoEntityFound;

    public ArrayList<E> getAll();
}
