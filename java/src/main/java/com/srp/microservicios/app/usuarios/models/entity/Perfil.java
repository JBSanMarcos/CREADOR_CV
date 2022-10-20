package com.srp.microservicios.app.usuarios.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="perfiles")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;
	private String apellidos;
	private String titulo;
	private String presentacion;
	
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getPresentacion() {
		return presentacion;
	}


	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}


	public Date getCreateAt() {
		return createAt;
	}
	
	@PrePersist
	public void prepersist() {
		this.createAt = new Date();
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
}
