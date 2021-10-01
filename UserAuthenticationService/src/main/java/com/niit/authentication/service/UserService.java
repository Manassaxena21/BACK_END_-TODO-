package com.niit.authentication.service;

import com.niit.authentication.exception.InvalidCredentialsException;
import com.niit.authentication.exception.UserAlreadyExistsException;
import com.niit.authentication.model.User;

public interface UserService {

	User saveUser(User user) throws UserAlreadyExistsException;
	
	User generateToken(User user) throws InvalidCredentialsException;

	String loginUser(User user) throws InvalidCredentialsException;

	String logoutUser(String token);

	User getUserEmail(String token);

}
