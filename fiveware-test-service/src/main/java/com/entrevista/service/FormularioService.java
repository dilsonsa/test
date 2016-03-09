package com.entrevista.service;

import java.util.List;

import com.entrevista.model.Formulario;

public interface FormularioService {

	void saveFormulario(Formulario formulario);

	void deleteFormularioBySsn(String ssn);

	List<Formulario> findAllFormularios();

}