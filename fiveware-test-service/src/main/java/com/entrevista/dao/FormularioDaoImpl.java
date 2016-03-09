package com.entrevista.dao;

import org.springframework.stereotype.Repository;

import com.entrevista.model.Formulario;

@Repository("FormularioDao")
public class FormularioDaoImpl extends AbstractDao<Integer, Formulario> implements FormularioDao {

	public void saveFormulario(Formulario formulario) {
		persist(formulario);
	}

}