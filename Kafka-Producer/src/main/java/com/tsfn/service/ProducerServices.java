package com.tsfn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerServices {

	@Value("${topic.name.producer}")
	private String topicName;

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
		log.info("daw : {}", message);
		kafkaTemplate.send(topicName, message);
	}

}
