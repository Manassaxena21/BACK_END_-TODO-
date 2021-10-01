package com.niit.userTaskService.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rabbitmq.domain.UserDto;

@Component
public class Producer {
	
	private  RabbitTemplate rabbitTemplate;
	private  DirectExchange directExchange;

	
	@Autowired
	public Producer(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.directExchange = directExchange;
	}
	public Producer(){}
	//dto category
	//dto mail
	public void sendMessageToRabbitMq(UserDto categoryDto) {
		rabbitTemplate.convertAndSend(directExchange.getName(),"task_RoutingKey",categoryDto);
	}

}
