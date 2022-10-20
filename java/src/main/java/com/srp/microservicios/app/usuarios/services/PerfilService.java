package com.srp.microservicios.app.usuarios.services;

import java.util.Optional;

import com.srp.microservicios.app.usuarios.models.entity.Perfil;

public interface PerfilService {
	
	public Iterable<Perfil> findAll();
	
	public Optional<Perfil> findById(Long id);
	
	public Perfil save(Perfil perfil);
	
	public void deleteById(Long id);
}
