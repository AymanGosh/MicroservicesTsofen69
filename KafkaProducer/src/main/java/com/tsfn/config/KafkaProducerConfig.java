package com.tsfn.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers ;
	
	
	
	//config producer and fit it properties 
	public Map<String ,Object> producerConfig()
	{
		Map<String ,Object> props= new HashMap<String, Object>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG ,bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}
	
	// create kafka producers instances 
	@Bean
	public ProducerFactory<String,String> producerFactory()
	{
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	// way to send masseges , need kafka template 
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate( ProducerFactory<String,String> producerFactory )
	{
		return new KafkaTemplate<String, String>(producerFactory);
	}
	
	
}

