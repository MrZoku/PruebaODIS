package com.who.organizadortarea;

public class Tarea {
    private String nombre;
    private boolean completada;

    public Tarea(String nombre, boolean completada) {
        this.nombre = nombre;
        this.completada = completada;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isCompletada() {
        return completada;
    }
}

