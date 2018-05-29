/*
 * Classe que abstrai a camada de regra de negocio o dao e as validações. 
 */
package org.fiveware.model;

import java.util.List;

import org.fiveware.beans.Cliente;
import org.fiveware.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component

public class ClienteModel {

	
	@Qualifier("clienteHibernateDao")
	private ClienteDao dao;
	
	
	@Autowired
	public ClienteModel(ClienteDao dao) {
		this.dao = dao;
	}
	

	public void cadastra(Cliente cliente) {
		dao.insere(cliente);
	}

	public void remove(Cliente cliente) {
		dao.remove(cliente);
	}

	public void altera(Cliente cliente) {
		dao.update(cliente);
	}

	public List<Cliente> todosClientes() {
		return dao.lista();
	}
}
