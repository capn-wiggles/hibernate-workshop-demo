package org.endava.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.endava.hibernate.model.Group;
import org.endava.hibernate.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroupService {

    private final GroupRepository groupRepository;

    public void saveGroup(Group group) {
        groupRepository.saveEntity(group);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(long id) {
        return groupRepository.findById(id);
    }
}
