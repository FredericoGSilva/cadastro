package com.cadastro.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.cadastro.api.service.UsuarioService;
import com.cadastro.api.service.exceptions.UsuarioException;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	UsuarioService service;

	@PostMapping(value = "/usuarios")
	public ResponseEntity<?> register(@RequestBody @Validated Usuario usuario) {
		try {
			Optional<Usuario> u = Optional.ofNullable(service.validateNameAndPassword(usuario));
			if (u.isPresent()) {
				Usuario savedUsuario = repository.save(u.get());
				return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
			} else {
				// Aqui você pode decidir sobre a resposta se o Optional estiver vazio
				return new ResponseEntity<>("Erro ao processar a solicitação: ", HttpStatus.BAD_REQUEST);
			}
		} catch (UsuarioException e) {
			return new ResponseEntity<>("Erro ao processar a solicitação: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/usuarios")
	public Usuario alter(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}

	@GetMapping(value = "/usuarios")
	public List<Usuario> returnAllUsers() {
		return repository.findAll();
	}

	@GetMapping("/usuarios/id/{id}")
	public Optional<Usuario> returnUserById(@PathVariable Integer id) {
		return repository.findById(id);
	}

	@GetMapping("/usuarios/nome/{nome}")
	public List<Usuario> returnByName(@PathVariable String nome) {
		return repository.findByNomeIgnoreCase(nome);
	}

	//Após desenvolver os métodos deleteUsuarioById e existsById, como usar o deleteById 
	
	@DeleteMapping(value = "/usuarios/delete/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteUsuarioById(id);
	}

}
