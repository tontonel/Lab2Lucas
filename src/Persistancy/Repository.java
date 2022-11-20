package Persistancy;

import java.util.ArrayList;
import java.util.Iterator;

import Domain.Identifiable;
import Domain.Patient;
import Exception.NoIdenticEntitiesException;
import Exception.NoEntityFound;

public class Repository<E extends Identifiable<Integer>> implements Iterable<E>, Persistancy<E>{

    private ArrayList<E> entityList = new ArrayList<>();

    @Override
    public Iterator<E> iterator() {
        return entityList.iterator();
    }

    public Repository(ArrayList<E> entityList) {
        this.entityList = entityList;
    }

    @Override
    public void addEntity(E entity) throws NoIdenticEntitiesException {
        for (E _entity : entityList)
            if (entity.getId() == _entity.getId())
                throw new NoIdenticEntitiesException(Integer.toString(entity.getId()));
        entityList.add(entity);
    }

    @Override
    public E deleteEntity(int id) {
        int indexToDelete = -1;
        int currentIndex = 0;
        for(E entity : entityList) {
            if (entity.getId() == id)
                indexToDelete = currentIndex;
            currentIndex++;
        }
        return entityList.remove(indexToDelete);
    }

    @Override
    public void updateEntity(int id, E entity) throws NoEntityFound {
        int currentIndex = 0;
        int updateIndex = -1;
        for(E _entity : entityList) {
            if (_entity.getId() == id)
                updateIndex = currentIndex;
            currentIndex++;
        }
        if(updateIndex == -1)
            throw new NoEntityFound(Integer.toString(id));
        entityList.remove(updateIndex);
        entityList.add(entity);
    }
    @Override
    public ArrayList<E> getAll() {
        return entityList;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "entityList=" + entityList +
                '}';
    }
}
