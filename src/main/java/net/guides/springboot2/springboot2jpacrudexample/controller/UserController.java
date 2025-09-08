package net.guides.springboot2.springboot2jpacrudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.model.User;
import net.guides.springboot2.springboot2jpacrudexample.repository.usersRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	usersRepo userRepo;
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		User existingUser = userRepo.findByEmail(user.getEmail());
		if (existingUser == null) {
			existingUser = userRepo.save(user);
		} else {
			existingUser.setMobNo(user.getMobNo());
			existingUser.setName(user.getName());
			existingUser.setPasscode(user.getPasscode());
			userRepo.save(existingUser);
		}
		return existingUser;
	}

	@GetMapping("/authorize")
	public User authorize(@RequestParam String email, @RequestParam String passCode) throws Exception {
		
		User existingUser =userRepo.findByEmailAndPasscode(email, passCode);
		if (existingUser == null) {
			throw new Exception("User Not Found");
		}else {
			return existingUser;
		}
	}
	
}
