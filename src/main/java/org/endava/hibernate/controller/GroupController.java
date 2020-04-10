package org.endava.hibernate.controller;

import lombok.RequiredArgsConstructor;
import org.endava.hibernate.model.Group;
import org.endava.hibernate.model.dto.GroupDto;
import org.endava.hibernate.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroupController {

    private final GroupService groupService;

    @PostMapping(value = "/groups")
    public ResponseEntity<Group> addGroup(@RequestBody GroupDto groupDto) {
        Group group = new Group();
        group.setName(groupDto.getGroupName());

        groupService.saveGroup(group);

        return ResponseEntity.ok().body(group);
    }

    @GetMapping(value = "/groups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Group>> findAll() {
        List<Group> groups = groupService.findAll();
        return ResponseEntity.ok().body(groups);
    }

    @GetMapping(value = "/groups/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> findById(@PathVariable long id) {
        Group group = groupService.findById(id);
        return ResponseEntity.ok().body(group);
    }

}
