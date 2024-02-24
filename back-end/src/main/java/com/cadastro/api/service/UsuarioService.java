package com.cadastro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.api.model.Usuario;
import com.cadastro.api.repository.UsuarioRepository;
import com.cadastro.api.service.exceptions.UsuarioException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	@PersistenceContext
	private EntityManager entity = null;
	
	public Usuario validateNameAndPassword(Usuario u) {
		if (u.getNome() == null || u.getNome().isEmpty() || u.getSenha() == null || u.getSenha().isEmpty() ) {
			throw new UsuarioException("Nome e Senha são obrigatórios.");
		}
		
		return u;
	}
	
	public void deleteUsuarioById(Integer id) {
		if (existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new UsuarioException("Id não encontrado.");
		}
	}
	
	private boolean existsById(Integer id) {
			return entity.createNamedQuery("Usuario.deleteById", Boolean.class)
			.setParameter("id", id).getSingleResult();
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
