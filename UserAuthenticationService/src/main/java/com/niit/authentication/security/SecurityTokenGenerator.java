package com.niit.authentication.security;

import java.util.Map;
import com.niit.authentication.model.User;

public interface SecurityTokenGenerator {

	Map<String,String> generateToken(User user);
}
