package com.cadastro.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cadastro.api.model.Usuario;

@Service
public class UsuarioService {
	
	public static ResponseEntity<Usuario> nameAndPassword(Usuario u) {
		if (u.getNome() == null || u.getNome().isEmpty() || u.getSenha() == null || u.getSenha().isEmpty() ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

/*	private UsuarioRepository repository;
	
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
	*/
	
}
