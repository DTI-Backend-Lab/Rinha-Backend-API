package io.github.henriqueaguiiar.rinhaDeBackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


/**
 * Entidade Person
 * @author Henrique Pacheo
 * @version 1.1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "tb_person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "surName")
    private String surName;
    @Column(name = "name")
    private String name;
    @Column(name = "bornDate")
    private String bornDate;
    @ManyToMany
    @JoinTable(name = "person_Stack", joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "stack_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"person_id", "stack_id"}))
    private Set<Stack> stack = new HashSet<>();

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", stack=" + stack +
                '}';
    }
}
