package io.github.henriqueaguiiar.rinhaDeBackend.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "tb_stack")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stack implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
