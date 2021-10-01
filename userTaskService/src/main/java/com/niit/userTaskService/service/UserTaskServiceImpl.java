package com.niit.userTaskService.service;

import java.util.Arrays;
import java.util.List;


import com.niit.userTaskService.configuration.Producer;
import com.niit.userTaskService.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.niit.userTaskService.Repository.UserTaskRepository;
import com.niit.userTaskService.domain.Tasks;
import com.niit.userTaskService.domain.User;
import com.niit.userTaskService.exception.UserNotFoundException;
import com.niit.userTaskService.exception.UserAlreadyExistsException;
import com.niit.userTaskService.exception.TaskNotFoundException;

import rabbitmq.domain.UserDto;

@Service
public class UserTaskServiceImpl implements UserTaskService {
	private UserProxy userProxy;
	private UserTaskRepository usertaskRepository;
	@Autowired
	private Producer producer;
	//private CategoryRepository categoryRepository;

	@Autowired
	public UserTaskServiceImpl(UserProxy userProxy,UserTaskRepository usertaskRepository ) {
		this.userProxy = userProxy;
		this.usertaskRepository = usertaskRepository;

	}
	
	@Override
    public User registerUser(User user) throws UserAlreadyExistsException {
		UserDto userDto=new UserDto();
		userDto.setEmail(user.getEmail());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
        if(usertaskRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        else
		{
			usertaskRepository.save(user);
			System.out.println("Registeration successful");
			producer.sendMessageToRabbitMq(userDto);
		}
        return user;
    }

	@Override
	public User saveUserTaskToList(Tasks tasks, String email) throws UserNotFoundException {
<<<<<<< HEAD
=======
		User users=new User();

		double randNumber = Math.random()* 100;
		int taskCode = (int)randNumber + 1;
		tasks.setTaskCode(taskCode);
>>>>>>> 973e71b8bf2c8c22c58c6f978a85ba0051b54677
		// TODO Auto-generated method stub

		if(usertaskRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = usertaskRepository.findByEmail(email);
        if(user.getTasklist() == null)
        {
            user.setTasklist(Arrays.asList(tasks));;
        }
        else {
            List<Tasks> task = user.getTasklist();
            task.add(tasks);
            user.setTasklist(task);
<<<<<<< HEAD

=======
>>>>>>> 973e71b8bf2c8c22c58c6f978a85ba0051b54677
        }
		//System.out.println(user);

        return usertaskRepository.save(user);
	}

	@Override
	public User saveTaskDb(MultipartFile file, User user) throws TaskNotFoundException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public User deleteUserTaskToList(String email, int taskCode) throws UserNotFoundException, TaskNotFoundException {
		// TODO Auto-generated method stub

        boolean taskIdisPresent = false;
        if(usertaskRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        User user = usertaskRepository.findById(email).get();
        List<Tasks> task = user.getTasklist();
        taskIdisPresent = task.removeIf(x->x.getTaskCode()==(taskCode));
        if(!taskIdisPresent)
        {
            throw new TaskNotFoundException();
        }
        user.setTasklist(task);
        return usertaskRepository.save(user);
	}

	@Override
	public User updateUserTaskToList(String email,int taskCode) throws UserNotFoundException {
		User user = usertaskRepository.findById(email).get();
		List<Tasks> task = user.getTasklist();
		System.out.println(task);
        for (Tasks tasks1: task) {
            if(tasks1.getTaskCode()== taskCode){
                boolean active = tasks1.isActive();
                active = !active;
                tasks1.setActive(active);
                System.out.println(active);
            }
        }

		return usertaskRepository.save(user);
	}

	@Override
	public List<Tasks> getallUserTask(String email) throws UserNotFoundException {
		// TODO Auto-generated method stub
		if(usertaskRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return usertaskRepository.findById(email).get().getTasklist();
	}
	
	//To addTask to the Service
	

}
