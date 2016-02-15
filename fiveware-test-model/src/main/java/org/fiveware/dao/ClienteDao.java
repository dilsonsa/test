package org.fiveware.dao;

import java.util.List;

import org.fiveware.beans.Cliente;

public interface ClienteDao {
 public void insere(Cliente cliente);
 public void update(Cliente cliente);
 public void remove(Cliente cliente);
 public List<Cliente>lista();	 
 
}
