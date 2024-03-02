package com.tsfn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfn.service.KafkaProducerImpl;

@RestController
public class KafkaMessageController {

	@Autowired
	private KafkaProducerImpl kafkaProducerImpl;
	
	@PostMapping("/publish/{message}")
	public String publishMessage(@PathVariable("message") String message)
	{
		kafkaProducerImpl.sendMessage(message);
		
		System.out.println("the message was published to Kafka successfully: "+ message);
		
		return "the message was published to Kafka successfully:" +message+"to the TsofenTopic"; 
	}
	
}
