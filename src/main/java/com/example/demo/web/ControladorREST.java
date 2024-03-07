package com.example.demo.web;

import com.example.demo.domain.Persona;
import com.example.demo.service.PersonaServicio;
import jakarta.validation.Valid;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorREST {
    
    @Autowired
    private PersonaServicio personaServicio;
    
    @GetMapping("/")
    public String index(Model model){
        List personas = (List) personaServicio.listarPersonas();
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Persona persona, Model model) {
        model.addAttribute("persona", persona);
        return "agregar_persona";
    }

    @PostMapping("/agregar")
    public String agregarPersona(@Valid @ModelAttribute Persona persona, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, redirige de vuelta al formulario de agregar_persona.html
            return "agregar_persona";
        }
        personaServicio.agregar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable("id") Long id, Model model) {
        
        Persona persona = personaServicio.buscarPersona(new Persona(id));
        if (persona != null) {
            model.addAttribute("persona", persona);
            return "agregar_persona";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/actualizar")
    public String actualizarPersona(@Valid @ModelAttribute Persona persona, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Si hay errores de validación, redirige de vuelta al formulario de agregar_persona.html
            return "agregar_persona";
        }
        personaServicio.actualizar(persona);
        return "redirect:/";
    }
    
    @PostMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable("id") Long id) {
        Persona persona = personaServicio.buscarPersona(new Persona(id));
        if (persona != null) {
            personaServicio.eliminar(persona);
        }
        return "redirect:/";
    }
}
