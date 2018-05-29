package org.fiveware.builder;

import org.fiveware.beans.Cliente;
import org.fiveware.beans.Endereco;
import org.fiveware.beans.Telefone;
import org.springframework.stereotype.Component;

@Component
public class ClienteBuilder {

	private Cliente cliente;
	private Endereco endereco;
	private Telefone fixo;
	private Telefone celular;

	public ClienteBuilder() {
		cliente = new Cliente();
		endereco = new Endereco();
		fixo = new Telefone();
		celular = new Telefone();
	}

	public ClienteBuilder comNome(String nome) {
		cliente.setNome(nome);
		return this;
	}

	public ClienteBuilder comTipoLogradouro(String tipoLogradouro) {
		endereco.setTipoLogradouro(tipoLogradouro);
		return this;
	}

	public ClienteBuilder comNumero(String numero) {
		endereco.setNumero(numero);
		return this;
	}

	public ClienteBuilder comBairro(String bairro) {
		endereco.setBairro(bairro);
		return this;
	}

	public ClienteBuilder comEstado(String estado) {
		endereco.setEstado(estado);
		return this;
	}

	public ClienteBuilder comCidade(String cidade) {
		endereco.setCidade(cidade);
		return this;
	}

	public ClienteBuilder comCelular(String numero) {
		celular.setNumero(numero);
		celular.setNome("celular");
		return this;
	}

	public ClienteBuilder comTelefoneFixo(String numero) {
		fixo.setNumero(numero);
		fixo.setNome("telefoneFixo");
		return this;
	}

	public ClienteBuilder comLogradouro(String logradouro) {
		endereco.setLogradouro(logradouro);
		return this;
	}

	public Cliente constroi() {
		cliente.setCelular(celular);
		cliente.setFixo(fixo);
		cliente.setResidencial(endereco);

		return cliente;
	}

}
