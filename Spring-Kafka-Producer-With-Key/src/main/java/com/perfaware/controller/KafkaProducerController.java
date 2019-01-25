package com.perfaware.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perfaware.service.KafkaProducerService;

@Controller
public class KafkaProducerController {
	
	private KafkaProducerService springKafkaService;
	
	private KafkaProducerController(KafkaProducerService springKafkaService) {
		this.springKafkaService = springKafkaService;
	}

	@PostMapping("springkafka/{topicName}/{key}")
	@ResponseBody
	public ResponseEntity<String> Controller(@RequestBody Object kafkaRequestBody,
			@PathVariable("topicName") String topicName,
			@PathVariable("key")String key
		) {
		
		return springKafkaService.Service(topicName,key, kafkaRequestBody);

	}
}
