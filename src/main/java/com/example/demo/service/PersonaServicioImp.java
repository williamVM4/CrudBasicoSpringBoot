package com.example.demo.service;

import com.example.demo.dao.PersonaDao;
import com.example.demo.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServicioImp implements PersonaServicio{
    
    @Autowired
    private PersonaDao personaDao;
    
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }
    
    @Transactional
    public void agregar(Persona persona) {
        personaDao.save(persona);
    }
    
    @Transactional
    public void actualizar(Persona persona) {
        personaDao.save(persona);
    }
    
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }
    
    @Transactional
    public Persona buscarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
