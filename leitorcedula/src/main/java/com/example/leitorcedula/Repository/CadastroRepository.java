package com.example.leitorcedula.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.leitorcedula.Model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Long> {
}