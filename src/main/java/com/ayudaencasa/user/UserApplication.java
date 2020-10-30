package com.ayudaencasa.user;

import com.ayudaencasa.user.model.User;
import com.ayudaencasa.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class UserApplication {

	@Autowired
	private UserRepository repository;

	@GetMapping("/getuser/{uId}")
	public User findUser(@PathVariable String uId){
		return repository.findUserByuId(uId);
	}

	@PostMapping("/saveuser")
	public User AddUser(@RequestBody User user){
		return repository.addUser(user);
	}

	@DeleteMapping("/deleteuser")
	public String DeleteUser(@RequestBody User user){
		return repository.deleteUser(user);
	}

	@PutMapping("/updateuser")
	public String UpdateUser(@RequestBody User user){
		return repository.editUser(user);
	}

	@GetMapping
	public User[] GetAllUsers(String uId){
		User users[] = new User[0];
		return users;
	}
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
