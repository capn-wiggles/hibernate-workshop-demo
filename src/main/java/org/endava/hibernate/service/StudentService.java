package org.endava.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.endava.hibernate.model.Student;
import org.endava.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void saveStudent(Student student) {
        studentRepository.saveEntity(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(long id) {
        return studentRepository.findById(id);
    }

}
