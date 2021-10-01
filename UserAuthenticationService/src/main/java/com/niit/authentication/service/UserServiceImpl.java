package com.niit.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.authentication.exception.InvalidCredentialsException;
import com.niit.authentication.exception.UserAlreadyExistsException;
import com.niit.authentication.model.User;
import com.niit.authentication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
		if(userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
		return userRepository.save(user);
	}

	@Override
	public User generateToken(User user) throws InvalidCredentialsException {
		User loggedInUser = new User() ;
		if(user.getUsername() == null){
			loggedInUser = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		}
		if(user.getEmail() == null){
			loggedInUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		}
        if(loggedInUser == null)
        {
            throw new InvalidCredentialsException();
        }
		return loggedInUser;
	}

	@Override
	public String loginUser(User user) throws InvalidCredentialsException {

		User loginUser = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		loginUser.setPassword(user.getPassword());
		loginUser.setToken(user.getToken());
		userRepository.save(loginUser);

		return loginUser.getUsername()+" logged In";
	}

	@Override
	public String logoutUser(String token) {
		User loggedInUser = userRepository.findByToken(token);
		loggedInUser.setToken(null);
		userRepository.save(loggedInUser);
		return "Logged Out";
	}

	@Override
	public User getUserEmail(String token) {
		User loggedInUser = userRepository.findByToken(token);
		System.out.println(loggedInUser);
		return loggedInUser;
	}


}
