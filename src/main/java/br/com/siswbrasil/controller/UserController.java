package br.com.siswbrasil.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siswbrasil.model.User;
import br.com.siswbrasil.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User user) {
		User obj = service.create(user);
		return ResponseEntity.ok(obj);
	}

}
