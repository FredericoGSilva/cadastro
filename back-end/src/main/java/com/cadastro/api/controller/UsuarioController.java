package com.cadastro.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import io.github.cdimascio.dotenv.Dotenv;
import com.cadastro.api.model.Usuario;
import com.cadastro.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@PostMapping(value = "/usuarios")
	public Usuario register(@RequestBody Usuario usuario) {
		return repository.save(usuario);
	}
	
	@GetMapping(value = "/usuarios")
	public List<Usuario> returnUser() {
		return repository.findAll();
	}
	
}
