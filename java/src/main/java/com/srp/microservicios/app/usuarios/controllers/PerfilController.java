package com.srp.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srp.microservicios.app.usuarios.models.entity.Perfil;
import com.srp.microservicios.app.usuarios.services.PerfilService;

@RestController
public class PerfilController {

	@Autowired
	private PerfilService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<Perfil> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Perfil perfil) {
		Perfil perfilDb = service.save(perfil);
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilDb);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Perfil perfil, @PathVariable Long id) {
		Optional<Perfil> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Perfil perfilDb = o.get();
		perfilDb.setNombres(perfil.getNombres());
		perfilDb.setApellidos(perfil.getApellidos());
		perfilDb.setTitulo(perfil.getTitulo());
		perfilDb.setPresentacion(perfil.getPresentacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(perfilDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> elminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
}
