package com.cadastro.api.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cadastro.api.model.Usuario;
import com.cadastro.api.repository.UsuarioRepository;
/*
@Service

public class UsuarioService {

	private UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public ResponseEntity<Usuario> alterUser(Integer id, Usuario novoUsuario) {
		Optional<Usuario> usuarioOptional = repository.findById(id);
		
		if (usuarioOptional.isPresent()) {
			Usuario usuarioExistente = usuarioOptional.get();
			usuarioExistente.setNome(novoUsuario.getNome());
			usuarioExistente.setSenha(novoUsuario.getSenha());
			repository.save(usuarioExistente);
			result(novoUsuario, "Usuário atualizado com sucesso");
			return ResponseEntity.ok(usuarioExistente);
		} else {
			result(null, "Usuário com ID " + id + " não encontrado");
			return ResponseEntity.notFound().build();
			
		}
		
	}
	
	private String result(Usuario usuario, String mensagem) {
		return mensagem;
	}
	
	
}
*/