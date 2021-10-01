package com.niit.userTaskService.proxy;

import com.niit.userTaskService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-authentication-service",url="localhost:8086")
public interface UserProxy {
    @PostMapping("/api/v1/register")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
