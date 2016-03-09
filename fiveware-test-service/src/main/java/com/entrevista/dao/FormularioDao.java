package com.entrevista.dao;

import java.util.List;

import com.entrevista.model.Formulario;

public interface FormularioDao {

	void saveFormulario(Formulario employee);



	List<Formulario> findAllFormulario();

	Formulario findFormularioBySsn(String ssn);

}