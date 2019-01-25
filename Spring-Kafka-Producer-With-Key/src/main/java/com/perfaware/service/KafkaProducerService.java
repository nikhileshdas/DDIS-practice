package com.perfaware.service;


import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {
	
	private KafkaTemplate<String, Object> kafkaTemplate;

	private KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate){
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public ResponseEntity<String> Service(String topicName,String key, Object kafkaRequestBody){

		kafkaTemplate.send(topicName,key, kafkaRequestBody);
		
		return ResponseEntity.status(200).body("Data added to "+topicName+ "with key value " + key+" topic and data is "+kafkaRequestBody);
	}
}