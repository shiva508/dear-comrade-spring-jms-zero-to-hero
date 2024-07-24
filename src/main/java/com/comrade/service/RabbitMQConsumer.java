package com.comrade.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.comrade.modal.User;

@Service
public class RabbitMQConsumer {

	@RabbitListener(queues = {"TEST"})
	public void sendEmailConsumer(User user) {
		System.out.println(user.getUserName());
	}
}
