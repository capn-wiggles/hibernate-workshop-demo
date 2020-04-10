package org.endava.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sequence_generator")
    @SequenceGenerator(name = "group_sequence_generator", initialValue = 50)
    private long id;

    @Column(name = "group_name", columnDefinition = "varchar(10) unique not null")
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Student> students;
}
