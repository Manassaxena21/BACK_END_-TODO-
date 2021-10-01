package com.niit.authentication;

import com.niit.authentication.exception.UserAlreadyExistsException;
import com.niit.authentication.model.User;
import com.niit.authentication.repository.UserRepository;
import com.niit.authentication.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private User user;
    List<User> userList;

    @BeforeEach
    public void setup(){
        user = new User("vivek@123","vivek","Vivek222","");
    }

    @AfterEach
    public void tearDown(){
        user = null;
    }

    @Test
    public void givenUserToSaveReturnSavedUserSuccess() throws UserAlreadyExistsException {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.ofNullable(null));
        when(userRepository.save(any())).thenReturn(user);
        assertEquals(user, userServiceImpl.saveUser(user));
        verify(userRepository,times(1)).save(any());
        verify(userRepository,times(1)).findByEmail(any());
    }

    @Test
    public void givenUserToSaveReturnSavedUserFailure() {
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.ofNullable(user));
        assertThrows(UserAlreadyExistsException.class,()->userServiceImpl.saveUser(user));
        verify(userRepository,times(0)).save(any());
        verify(userRepository,times(1)).findByEmail(any());
    }
}
