package com.example.startproj.service;

import com.example.startproj.dto.TaskDTO;
import com.example.startproj.entity.EventEntity;
import com.example.startproj.entity.TaskEntity;
import com.example.startproj.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public void postTask(TaskDTO taskDTO) {
        var task = new TaskEntity();
        task.setName(taskDTO.name());

        Set<EventEntity> events = taskDTO.events().stream()
                .map(title -> new EventEntity(title, task))
                .collect(Collectors.toSet());
        task.setEvents(events);

        taskRepository.save(task);
    }

    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(task -> new TaskDTO(
                        task.getName(),
                        task.getEvents().stream()
                                .map(EventEntity::getTitle).toList()
                )).toList();
    }
}
