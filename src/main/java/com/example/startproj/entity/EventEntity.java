package com.example.startproj.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Table(name = "event")
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    TaskEntity task;

    public EventEntity(String title, TaskEntity task) {
        this.title = title;
        this.task = task;
    }
}
