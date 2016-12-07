package org.fiveware.model;

import org.pojomatic.annotations.AutoProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by valdisnei on 12/4/16.
 */
@AutoProperty
@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "status")
	private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {return estadoCivil;}

	public void setEstadoCivil(String estadoCivil) {this.estadoCivil = estadoCivil;}

	public Boolean getStatus() {return status;}

	public void setStatus(Boolean status) {this.status = status;}

	public String getSexo() {return sexo;}

	public void setSexo(String sexo) {this.sexo = sexo;}
}
