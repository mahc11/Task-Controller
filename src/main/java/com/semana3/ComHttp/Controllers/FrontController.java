package com.semana3.ComHttp.Controllers;

import com.semana3.ComHttp.Entities.Task;
import com.semana3.ComHttp.Entities.Users;
import com.semana3.ComHttp.Services.TaskService;
import com.semana3.ComHttp.Services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontController {

    TaskService service;
    UserService serviceUser;

    public FrontController(TaskService service, UserService serviceUser){
        this.service=service;
        this.serviceUser= serviceUser;
    }

    @GetMapping("/")
    public String index (Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal !=null){
            Users usuario = serviceUser.getorCreateUser(principal.getClaims());
            model.addAttribute("usuario", usuario);
        }
        return "index.html";
    }

    @GetMapping("/tasker")
    public String tasks (Model modelo){
        List<Task> Tareas = this.service.getTasklist();
        modelo.addAttribute("tasks",Tareas);
        return "tasker";
    }

    @GetMapping("/tasker/new")
    public String newTask(Model modelo){
        modelo.addAttribute("tareanu", new Task());
        return "new-task";
    }
}