package com.radisson.user.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {
	
	KafkaTemplate<String , String> kafkaTemplate;
	
	public void messageProducer(String _topic ,String _message) {
		kafkaTemplate.send(_topic, _message);
	}

	public void producerMessage(String string, String message) {
		// TODO Auto-generated method stub
		
	}
}
