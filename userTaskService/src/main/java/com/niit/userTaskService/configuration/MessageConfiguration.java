package com.niit.userTaskService.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageConfiguration {
	public static final String queueName="task_Queue";
	public static final String exchangeName="task_Exchange";
	//Exchange Type for Queue in messaging service
	@Bean
	public Queue registerQueue() {
		return new Queue(queueName,false);
		
	}
	//Exchange Type for messaging service
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(exchangeName);
		
	}
	
	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
		
	}
	
	@Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemp=new RabbitTemplate(connectionFactory);
        rabbitTemp.setMessageConverter(converter());
        return rabbitTemp;
    }

	@Bean
	public Binding binding(Queue queue,DirectExchange directExchange) {
		return BindingBuilder.bind(queue).to(directExchange).with("task_RoutingKey");
	}
	

}
