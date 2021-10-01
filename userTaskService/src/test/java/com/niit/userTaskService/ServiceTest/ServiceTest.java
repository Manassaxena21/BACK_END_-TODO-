package com.niit.userTaskService.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.niit.userTaskService.Repository.UserTaskRepository;
import com.niit.userTaskService.domain.Tasks;
import com.niit.userTaskService.exception.UserNotFoundException;
import com.niit.userTaskService.service.UserTaskServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@Mock
	private UserTaskRepository taskRepository;
	
	@InjectMocks
	private UserTaskServiceImpl userService;
	private Tasks task;
	
	
	@BeforeEach
	public void setUp() {
		task=new Tasks(212, "Complete work", null, null, null, null , false);
	}
	
	@Test
	public void givenTaskToSaveReturn() throws UserNotFoundException {
		//when(taskRepository.findById(task.getTaskCode())).thenReturn(null);
		//assertEquals(task, userService.saveCategory(category, 0));
	}

}
