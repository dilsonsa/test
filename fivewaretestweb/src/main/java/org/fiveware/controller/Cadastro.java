package org.fiveware.controller;

import org.fiveware.model.Usuario;
import org.fiveware.service.UsarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by valdisnei on 12/2/16.
 */

@RestController
@RequestMapping("/api/v1")
public class Cadastro{

	@Autowired
	private UsarioService usarioService;

	@RequestMapping(value = "/usuarios", method = GET)
	public List<Usuario> listUsers() {
		return usarioService.findAll();
	}

	@RequestMapping(value = "/cadastrar", method = POST)
	public Usuario addUsers(@RequestBody Usuario usuario) {
		Usuario usuario1 = null;
		if (usuario.getId()<0)
			 usuario1 = usarioService.addUser(usuario);
		else
			usuario1 = usarioService.editUser(usuario);

		return usuario1;
	}


	@RequestMapping(value = "/editar", method = POST)
	public Usuario editUser(@RequestBody Usuario usuario) {

		Usuario usuario1 = usarioService.editUser(usuario);

		return usuario1;
	}

	@RequestMapping(value = "/remover", method = POST)
	public Usuario removeUser(@RequestBody Usuario usuario) {
		Usuario usuario1 = usarioService.removeOne(usuario);
		return usuario1;
	}


	@RequestMapping(value = "/usuario/{id}", method = GET)
	public Usuario editUsers(@PathVariable Long id) {
		Usuario usuario1 = usarioService.findOne(id);
		return usuario1;
	}



}
