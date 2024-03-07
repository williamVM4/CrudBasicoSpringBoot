package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotNull
    @Min(0) 
    private int edad;
    
    @NotEmpty
    @Email
    private String correo;
    
    @NotEmpty
    private String telefono;
    
    public Persona(){
    }
    
    public Persona(Long idPersona){
        this.idPersona = idPersona;
    }
    
}
