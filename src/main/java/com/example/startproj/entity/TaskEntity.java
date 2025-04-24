package com.example.startproj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Table(name = "task")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    Set<EventEntity> events = new HashSet<>();

    public TaskEntity(String name, Set<EventEntity> events) {
        this.name = name;
        this.events = events;
    }
}
