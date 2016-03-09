package com.entrevista.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entrevista.dao.FormularioDao;
import com.entrevista.model.Formulario;

@Service("formularioService")
@Transactional
public class FormularioServiceImpl implements FormularioService {

	@Autowired
	private FormularioDao dao;

	public void saveFormulario(Formulario formulario) {
		dao.saveFormulario(formulario);
	}

}