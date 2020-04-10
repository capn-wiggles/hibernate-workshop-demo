package org.endava.hibernate.controller;

import lombok.RequiredArgsConstructor;
import org.endava.hibernate.model.Group;
import org.endava.hibernate.model.Student;
import org.endava.hibernate.model.dto.StudentDto;
import org.endava.hibernate.service.GroupService;
import org.endava.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        Group group = groupService.findById(studentDto.getGroupId());
        student.setGroup(group);

        studentService.saveStudent(student);

        return ResponseEntity.ok().body(student);
    }

    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> findById(@PathVariable long id) {
        Student student = studentService.findById(id);
        return ResponseEntity.ok().body(student);
    }

}
