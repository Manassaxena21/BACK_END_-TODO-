package com.niit.userTaskService.ControllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.niit.userTaskService.Repository.UserTaskRepository;
import com.niit.userTaskService.controller.TaskController;
import com.niit.userTaskService.domain.Tasks;
import com.niit.userTaskService.service.UserTaskServiceImpl;
import com.niit.userTaskService.exception.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private UserTaskServiceImpl userTaskService;
	
	@InjectMocks
	private TaskController taskController;
	private Tasks task;
	
	@BeforeEach
	public void setUp() {
		task=new Tasks(212, "Complete work", null, null, null, null,false);
	}
	
	@Test
	public void returnSaveTaskSuccess() throws Exception {
	      //when(userTaskService.saveTaskDb(null, task).thenReturn();
	      //mockMvc.perform(post("/api/v1/customerservice/customer")
	            //  .contentType(MediaType.APPLICATION_JSON)
	              //.content(jsonToString(customer1)))
	              //.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
	       // verify(customerService,times(1)).saveCustomerDetail(any());
	    }

}
