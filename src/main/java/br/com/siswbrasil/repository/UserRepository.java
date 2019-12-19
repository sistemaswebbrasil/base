package br.com.siswbrasil.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.siswbrasil.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
