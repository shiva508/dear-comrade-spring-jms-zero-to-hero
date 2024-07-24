package com.comrade.consumer;

import com.comrade.model.Order;
import com.comrade.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
	@Autowired
	private OrderRepository orderRepository;
	@JmsListener(destination="OrderQueue",containerFactory="custom")
	public void receiveMessage(Order order) {
		System.out.println(order+"TRANSACTION STARTED");
		orderRepository.save(order);
	}
}
