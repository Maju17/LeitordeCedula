package com.example.leitorcedula.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.leitorcedula.Model.Cedula;
import com.example.leitorcedula.Repository.CedulaRepository;

@RestController
@CrossOrigin
public class CedulaController {

    @Autowired
    CedulaRepository cedulasRepository;

    @PostMapping("/Cedula")
    public Cedula addCedula(@RequestBody Cedula Cedula) {
        return cedulasRepository.save(Cedula);
    }
    
    @GetMapping("/Cedula")
    public List<Cedula> listarCedula() {
        return (List<Cedula>) cedulasRepository.findAll();
    }

    @GetMapping("/Cedula/{id}")
    public Optional<Cedula> listarCedulaId(@PathVariable("id") Long id) {
        if(cedulasRepository.existsById(id)){
            return cedulasRepository.findById(id);
        }else{
            return null;
        }
    }

    @DeleteMapping("/Cedula/{id}")
    public String deleteCedula(@PathVariable("id") Long id){
        if(cedulasRepository.existsById(id)){
            cedulasRepository.deleteById(id);
            return "Cedula excluida com sucesso!";
        }else{
            return "Cedula não reconhecida!";
        }
    }
}
