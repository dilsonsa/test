package org.fiveware.repository;

import org.fiveware.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by valdisnei on 12/2/16.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

	List<Usuario> findAll();

	Usuario findByEmail(String email);
}
