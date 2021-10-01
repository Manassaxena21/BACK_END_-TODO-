package com.niit.userTaskService.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.niit.userTaskService.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends MongoRepository<User,String> {
	User findByEmail(String email);

}
