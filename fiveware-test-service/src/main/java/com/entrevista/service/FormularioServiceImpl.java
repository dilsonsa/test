package com.entrevista.service;

import java.util.List;

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

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	


	public List<Formulario> findAllFormularios() {
		return dao.findAllFormulario();
	}

	public Formulario findFormularioBySsn(String ssn) {
		return dao.findFormularioBySsn(ssn);
	}

	@Override
	public void deleteFormularioBySsn(String ssn) {
		// TODO Auto-generated method stub
		
	}

}