package com.example.leitorcedula.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.leitorcedula.Model.Cedula;

public interface CedulaRepository extends CrudRepository<Cedula, Long> {
}
