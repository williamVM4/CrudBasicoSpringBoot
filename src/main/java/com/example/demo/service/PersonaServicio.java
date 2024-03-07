package com.example.demo.service;

import com.example.demo.domain.Persona;
import java.util.List;

public interface PersonaServicio {
    
    public List<Persona> listarPersonas();
    
    public void agregar(Persona persona);
    
    public void actualizar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona buscarPersona(Persona persona);
}
