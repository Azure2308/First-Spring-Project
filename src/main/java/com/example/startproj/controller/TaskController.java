package com.example.startproj.controller;

import com.example.startproj.dto.TaskDTO;
import com.example.startproj.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/post")
    public void postTask(@RequestBody TaskDTO taskDTO){
        taskService.postTask(taskDTO);
    }

    @GetMapping("/get")
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }
}
