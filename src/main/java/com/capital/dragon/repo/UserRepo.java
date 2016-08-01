package com.capital.dragon.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.capital.dragon.model.User;

public interface UserRepo  extends CrudRepository<User,Long> {
	//@Query("select o from Order o where o.customer.id = ?#{principal.id} or 1=?#{hasRole('ROLE_ADMIN') ? 1: 0}")
	User findByLogin(String login);
	User findByEmail(String email);

}
