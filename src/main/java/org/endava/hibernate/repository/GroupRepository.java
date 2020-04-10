package org.endava.hibernate.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.endava.hibernate.model.Group;
import org.endava.hibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class GroupRepository implements CustomRepository<Group> {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Group saveEntity(Group entity) {
        log.info(String.format("Saving Group(%s) to database", entity.getName()));

        entityManager.persist(entity);

        return entity;
    }

    @Override
    public List<Group> findAll() {
        log.info("Fetching all groups");

        Query query = entityManager.createQuery("SELECT g FROM Group g");

        List<Group> allGroups = query.getResultList();

        return allGroups;
    }

    @Override
    public Group findById(long id) {
        log.info(String.format("Fetching a group with id=%d", id));

        Group group = entityManager.find(Group.class, id);

        return group;
    }
}
