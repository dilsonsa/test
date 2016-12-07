package org.fiveware.service;

import org.fiveware.model.Usuario;
import org.fiveware.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by valdisnei on 12/4/16.
 */
@Service
public class UsarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;


	public List<Usuario> findAll(){
		List<Usuario> all = usuarioRepository.findAll();
		Optional<List<Usuario>> allOpt = Optional.ofNullable(all);
		if (allOpt.isPresent())
			Collections.sort(all, Comparator.comparing(Usuario::getId));

		return allOpt.get();
	}

	public Usuario addUser(Usuario usuario){
		return usuarioRepository.save(usuario);
	}

	public Usuario editUser(Usuario usuario){
		Usuario usuario1 = usuarioRepository.findByEmail(usuario.getEmail());
		usuario.setId(usuario1.getId());
		Usuario save = usuarioRepository.save(usuario);
		return save;
	}

	public Usuario findOne(Long id){
		return usuarioRepository.findOne(id);
	}

	public Usuario removeOne(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return usuario;
	}
}
