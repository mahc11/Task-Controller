package com.semana3.ComHttp.Services;

//Logica que permite instanciar o crear los elementos dentro del programa

import com.semana3.ComHttp.Entities.Task;
import com.semana3.ComHttp.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService (TaskRepository repository){
        this.repository = repository;
    }

    public List<Task> getTasklist(){
        return this.repository.findAll();
    }

    public Task createTask (Task newTask){
        return this.repository.save(newTask);
    }

    public Boolean taskFinished (Integer id){

        Optional<Task> tarea = this.repository.findById(id);

        if (tarea.isPresent()){
            tarea.get().setDone(true);
            this.repository.save(tarea.get());
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean taskDelete (Integer id){
        this.repository.deleteById(id);
        return true;
    }

}
