package com.ayudaencasa.user;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.ayudaencasa.user.model.User;
import com.ayudaencasa.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000", "http://ayudaencasa-proyectointegrador.s3-website-us-east-1.amazonaws.com"})
@RestController
@SpringBootApplication
@RequestMapping(value = "/users")
public class UserApplication {

	@Autowired
	private UserRepository repository;

	@GetMapping("/{uId}")
	public User findUser(@PathVariable String uId){
		return repository.findUserByuId(uId);
	}

	@PostMapping
	public User AddUser(@RequestBody User user){
		return repository.addUser(user);
	}

	@DeleteMapping
	public String DeleteUser(@RequestBody User user){
		return repository.deleteUser(user);
	}

	@PutMapping
	public String UpdateUser(@RequestBody User user){
		return repository.editUser(user);
	}

	@GetMapping
	public PaginatedScanList<User> GetAllUsers(){
		return repository.findAllUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
