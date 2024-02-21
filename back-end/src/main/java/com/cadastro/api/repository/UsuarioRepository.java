package com.cadastro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.api.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	
}