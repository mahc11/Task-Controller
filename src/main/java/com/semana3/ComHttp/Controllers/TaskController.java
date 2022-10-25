package com.semana3.ComHttp.Controllers;

import com.semana3.ComHttp.Entities.Task;
import com.semana3.ComHttp.Services.TaskService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

//Llama a los servicios y crea la visualización del usuario, por lo que no crea elementos si no solo el servicio

@RestController
public class TaskController {
    TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @PostMapping("/tasker")
    public RedirectView CreateTask(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Task tarea, Model modelo){
        modelo.addAttribute(tarea);
        tarea.setDone(false);
        this.service.createTask(tarea);
        return new RedirectView("/tasker");
    }

    @PatchMapping("/tasker/{id}")
    public RedirectView updateTask (@PathVariable("id") Integer id ){
        this.service.taskFinished(id);
        return new RedirectView("/tasker");
    }

    @DeleteMapping("/tasker/{id}")
    public RedirectView deleteTask (@PathVariable("id") Integer id ){
        this.service.taskDelete(id);
        return new RedirectView("/tasker");
    }


}
