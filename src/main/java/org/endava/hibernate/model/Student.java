package org.endava.hibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence_generator")
    @SequenceGenerator(name = "student_sequence_generator", initialValue = 10)
    private long id;

    @Column(name = "student_name")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private Group group;
}
