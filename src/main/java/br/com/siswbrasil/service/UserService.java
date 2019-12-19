package br.com.siswbrasil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.siswbrasil.model.User;
import br.com.siswbrasil.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User create(User entity) {
		return repository.save(entity);
	}

}
