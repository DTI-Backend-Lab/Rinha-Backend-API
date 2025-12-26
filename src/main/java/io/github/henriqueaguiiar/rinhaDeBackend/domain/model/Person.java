package io.github.henriqueaguiiar.rinhaDeBackend.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity()
@Table(name = "tb_person")
public class Person implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "surName")
    private String surName;
    @Column(name = "name")
    private String name;
    @Column(name = "bornDate")
    private LocalDate bornDate;
    @Column(name = "stack")
    private List<String> stack;


    public Person() {
    }

    public Person(String id, String surName, String name, LocalDate bornDate, List<String>  stack) {
        this.id = id;
        this.surName = surName;
        this.name = name;
        this.bornDate = bornDate;
        this.stack = stack;
    }

    public String getId() {
        return id;
    }


    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
