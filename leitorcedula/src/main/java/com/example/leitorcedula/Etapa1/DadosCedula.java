package com.example.leitorcedula.Etapa1;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.example.leitorcedula.Model.Cedula;

public class DadosCedula {
    private static ArrayList<Cedula> cedulas;
	
    public static void init(){
        cedulas = new ArrayList<Cedula>();
        cedulas.add(new Cedula("Azul", "100"));
    }

	public DadosCedula() {
        cedulas = new ArrayList<>();
    }

    public static void add(Cedula cedula) {
		 cedulas.add(cedula);
	}

    public static void deletar(Cedula cedula) {
        Predicate<Cedula> criterio = cedulalista -> cedulalista.getId() == cedula.getId();
		cedulas.removeIf(criterio);
	}

    public static ArrayList<Cedula> all() {
        return cedulas;
    }
}
