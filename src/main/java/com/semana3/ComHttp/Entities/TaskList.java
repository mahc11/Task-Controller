package com.semana3.ComHttp.Entities;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TaskList {

    private String name;
    private List<Task> Tareas;


    //Constructor del Task-list vacio.
    public TaskList(String name) {
        this.name = name;
        this.Tareas = new ArrayList<Task>();       //Inicia la lista Tareas como un arraylist del objeto tareas
    }


    public void addTarea (Task task){
        this.Tareas.add(task);          //Se agrega con add a la lista la tarea
    }

    public void removeTask (String Description){
        this.Tareas = Tareas.stream().filter(t -> {return !t.getDescription().equals(Description);}).collect(Collectors.toList());
    }

    public void printTareas(){
        this.Tareas.forEach(task -> {
            System.out.println("Descripción: ");
            System.out.println(task.getDescription());
            System.out.println("fecha: ");
            System.out.println(task.getDueDate());
            System.out.println("Realizada: ");
            System.out.println(task.isDone());
            System.out.println("------------------------------------------------");
        });

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTareas() {
        return Tareas;
    }

    public void setTareas(List<Task> tareas) {
        Tareas = tareas;
    }



}