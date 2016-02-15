package org.fiveware.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Cliente {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	@OneToOne
	private Documento rg;
	@OneToOne
	private Documento cpf;
	@OneToOne
	private Endereco comercial;
	@OneToOne
	private Endereco residencial;
	@OneToOne
	private Telefone celular;
	@OneToOne
	private Telefone fixo;
	private boolean bloqueado =false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Documento getRg() {
		return rg;
	}

	public void setRg(Documento rg) {
		this.rg = rg;
	}

	public Documento getCpf() {
		return cpf;
	}

	public void setCpf(Documento cpf) {
		this.cpf = cpf;
	}

	public Endereco getComercial() {
		return comercial;
	}

	public void setComercial(Endereco comercial) {
		this.comercial = comercial;
	}

	public Endereco getResidencial() {
		return residencial;
	}

	public void setResidencial(Endereco residencial) {
		this.residencial = residencial;
	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public Telefone getFixo() {
		return fixo;
	}

	public void setFixo(Telefone fixo) {
		this.fixo = fixo;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}