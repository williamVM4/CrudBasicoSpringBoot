package com.example.demo.dao;

import com.example.demo.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona,Long>{
    
}
