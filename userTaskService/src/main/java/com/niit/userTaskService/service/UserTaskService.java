package com.niit.userTaskService.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.niit.userTaskService.domain.Tasks;
import com.niit.userTaskService.domain.User;
import com.niit.userTaskService.exception.UserNotFoundException;
import com.niit.userTaskService.exception.UserAlreadyExistsException;
import com.niit.userTaskService.exception.TaskNotFoundException;


public interface UserTaskService {
	User registerUser(User user) throws UserAlreadyExistsException;
	User saveUserTaskToList(Tasks tasks,String email) throws UserNotFoundException;
	User saveTaskDb(MultipartFile file,User user) throws TaskNotFoundException;
	User deleteUserTaskToList(String email,int taskCode)throws UserNotFoundException,TaskNotFoundException;
	User updateUserTaskToList(String email,int taskCode)throws UserNotFoundException;
	List<Tasks> getallUserTask(String email) throws UserNotFoundException;

}
