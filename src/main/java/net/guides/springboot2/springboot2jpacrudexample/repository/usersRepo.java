package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.User;

@Repository
public interface usersRepo extends JpaRepository<User, Long>{

	User findByEmail(String email);
	User findByEmailAndPasscode(String email,String passcode);
}
