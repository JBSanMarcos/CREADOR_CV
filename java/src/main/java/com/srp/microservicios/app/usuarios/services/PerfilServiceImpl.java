package com.srp.microservicios.app.usuarios.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srp.microservicios.app.usuarios.models.entity.Perfil;
import com.srp.microservicios.app.usuarios.models.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilRepository repository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Perfil> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Perfil> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Perfil save(Perfil perfil) {
		return repository.save(perfil);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
