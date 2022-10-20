package com.srp.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.srp.microservicios.app.usuarios.models.entity.Perfil;

public interface PerfilRepository extends CrudRepository<Perfil, Long> {

}
	