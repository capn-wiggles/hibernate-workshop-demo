package org.endava.hibernate.repository;

import javax.persistence.EntityManager;
import java.util.List;

public interface CustomRepository<E> {

    E saveEntity(E entity);
    List<E> findAll();
    E findById(long id);
}
