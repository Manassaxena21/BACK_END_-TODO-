package com.niit.authentication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.niit.authentication.exception.InvalidCredentialsException;
import com.niit.authentication.exception.UserAlreadyExistsException;
import com.niit.authentication.model.User;
import com.niit.authentication.security.SecurityTokenGenerator;
import com.niit.authentication.service.UserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {

	private final UserService userService;
	private final SecurityTokenGenerator securityTokenGenerator;

	@Autowired
	public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
		this.userService = userService;
		this.securityTokenGenerator = securityTokenGenerator;
	}

	//register user
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserAlreadyExistsException {

		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	// generate token for user
	@PostMapping("/generate")
	public ResponseEntity<?> generateToken(@RequestBody User user) throws InvalidCredentialsException {
		User retrievedUser = userService.generateToken(user);

		if (retrievedUser == null) {
			throw new InvalidCredentialsException();
		}
		Map<String, String> map = securityTokenGenerator.generateToken(user);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// login user
	@PutMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException {
		String response = userService.loginUser(user);
		return new ResponseEntity<>(response , HttpStatus.OK);
	}

	// logout user
	@DeleteMapping("/logout/user/{token}")
	public ResponseEntity<?> logOutUser(@PathVariable String token)  {
		String response = userService.logoutUser(token);
		return new ResponseEntity<>(response , HttpStatus.OK);
	}

	// get logged in user
	@GetMapping("loggedIn/user/{token}")
	public ResponseEntity<?> getUserEmail(@PathVariable String token) {
		User user = userService.getUserEmail(token);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
