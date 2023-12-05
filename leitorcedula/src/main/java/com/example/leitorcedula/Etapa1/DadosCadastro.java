package com.example.leitorcedula.Etapa1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.example.leitorcedula.Model.Cadastro;

public class DadosCadastro {
    private static ArrayList<Cadastro> cadastros;
	
    public static void init(){
        cadastros = new ArrayList<Cadastro>();
        cadastros.add(new Cadastro("Lucas", "Rua 1", "lucasGo@gmail.com"));
    }

	public DadosCadastro() {
        cadastros = new ArrayList<>();
    }

    public static void addDado(Cadastro cadastro) {
		cadastros.add(cadastro);
	}

    public static ArrayList<Cadastro> recuperaDado() {
        return cadastros;
    }
    
    public static void deletar(Cadastro cadastro) {
        Predicate<Cadastro> condicao = cadastroListaDeletar -> cadastroListaDeletar.getId() == cadastro.getId();
		cadastros.removeIf(condicao);
	}

    public static List<Cadastro> all(){
        return cadastros;
    }
}
