package ru.lugom.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(
        name = "cities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
        )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @Column(name="name", nullable = false)
    private String name;
    @NotEmpty
    @Column(name="info", nullable = false)
    private String info;
}
