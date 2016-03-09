package com.entrevista.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="form")
public class Formulario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String nome;
	Boolean java;
	Boolean csharp;
	String estadoCivil;
	Boolean trabalhando;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getJava() {
		return java;
	}
	public void setJava(Boolean java) {
		this.java = java;
	}
	public Boolean getCsharp() {
		return csharp;
	}
	public void setCsharp(Boolean csharp) {
		this.csharp = csharp;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Boolean getTrabalhando() {
		return trabalhando;
	}
	public void setTrabalhando(Boolean trabalhando) {
		this.trabalhando = trabalhando;
	}

}