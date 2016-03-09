package com.entrevista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entrevista.model.Formulario;
import com.entrevista.service.FormularioService;

@Controller
public class FormularioController {

	@Autowired
    FormularioService service;

	@RequestMapping("/formulario")
	public String execute(Formulario formulario) {
		System.out.println("Tentando salvar formulario...");

		service.saveFormulario(formulario);

		System.out.println(formulario.getNome());
		System.out.println(formulario.getEstadoCivil());
		System.out.println(formulario.getTrabalhando());
		System.out.println("Java: " + formulario.getJava());
		System.out.println("C#: " + formulario.getCsharp());

		return "ok";
	}

}
