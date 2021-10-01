package com.niit.userTaskService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.userTaskService.domain.Tasks;
import com.niit.userTaskService.domain.User;
import com.niit.userTaskService.exception.UserNotFoundException;
import com.niit.userTaskService.exception.UserAlreadyExistsException;
import com.niit.userTaskService.exception.TaskNotFoundException;
import com.niit.userTaskService.service.UserTaskService;


@RestController
@RequestMapping("/api/v2/")
@CrossOrigin
public class TaskController {
	private UserTaskService userTaskService;
	private ResponseEntity<?> responseEntity;
	@Autowired
	public TaskController(UserTaskService userTaskService) {
		//super();
		this.userTaskService = userTaskService;
		//this.responseEntity = responseEntity;
	}
	
	@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
    try {
        responseEntity =  new ResponseEntity<>(userTaskService.registerUser(user), HttpStatus.CREATED);
    }
    catch(UserAlreadyExistsException e)
    {
        throw new UserAlreadyExistsException();
    }
    return responseEntity;
    }


    @PostMapping("/user/tasks/{email}")
    public ResponseEntity<?> saveUserTaskToList(@RequestBody Tasks tasks, @PathVariable String email ) throws UserNotFoundException {
    try {
        responseEntity =  new ResponseEntity<>(userTaskService.saveUserTaskToList(tasks, email), HttpStatus.CREATED);
    }
    catch(UserNotFoundException e)
    {
        throw new UserNotFoundException();
    }
    return responseEntity;
    }
    
    @PostMapping("/saveTasks")
    public ResponseEntity<?> saveTaskDb(@RequestParam MultipartFile file,@RequestParam User user) throws TaskNotFoundException{
    	try {
    		responseEntity= new ResponseEntity<>(userTaskService.saveTaskDb(file, user), HttpStatus.CREATED);
    	}
    	catch(TaskNotFoundException e)
    	{
    		throw new TaskNotFoundException();
    	}
		return responseEntity;
		}
    
    @GetMapping("user/tasks/{email}")
    public ResponseEntity<?> getAllUserTask(@PathVariable String email) throws UserNotFoundException{
    	try {
    		responseEntity= new ResponseEntity<>(userTaskService.getallUserTask(email), HttpStatus.CREATED);
    	}
    	catch(UserNotFoundException e)
    	{
    		throw new UserNotFoundException();
    	}
		return responseEntity;
    	
    }
    @PutMapping("user/{email}/{taskCode}")
    public ResponseEntity<?> updateUserTaskToList(@PathVariable String email,@PathVariable int taskCode) throws UserNotFoundException{
    	try {
    		responseEntity= new ResponseEntity<>(userTaskService.updateUserTaskToList(email, taskCode), HttpStatus.CREATED);
    	}
    	catch(UserNotFoundException e)
    	{
    		throw new UserNotFoundException();
    	}
		return responseEntity;
    	
    }
   
    @DeleteMapping("user/{email}/{taskCode}")
    public ResponseEntity<?> deleteUserTaskToList(@PathVariable String email,@PathVariable int taskCode)
            throws UserNotFoundException, TaskNotFoundException
    {
        try {
            responseEntity = new ResponseEntity<>(userTaskService.deleteUserTaskToList(email, taskCode), HttpStatus.OK);
        } catch (UserNotFoundException | TaskNotFoundException m) {
            throw new TaskNotFoundException();
        }
        return responseEntity;
    }
    
    
  }
