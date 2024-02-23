package com.cadastro.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.github.cdimascio.dotenv.Dotenv;
import com.cadastro.api.model.Usuario;
import com.cadastro.api.repository.UsuarioRepository;
//import com.cadastro.api.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping(value = "/usuarios")
	public Usuario register(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@PutMapping(value = "/usuarios")
	public Usuario alter(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@GetMapping(value = "/usuarios")
	public List<Usuario> returnAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> returnUserById(
			@PathVariable Integer id) {
		return repository.findById(id);
	}
	
	@DeleteMapping(value = "/usuarios/{id}")
	public void delete(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	
}
