package com.pangaea.subscriber.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SubscriberOpsController {

	@PostMapping("/test1")
	public ResponseEntity<String> listener1(@RequestBody HashMap<String, Object> requestData) {
		log.info("============ PRINTING PUBLISHED MESSAGE ON LISTENER 1 ==============");
		log.info(String.valueOf(requestData));
		log.info("============= DONE PRINTING ===========");

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/test2")
	public ResponseEntity<String> listener2(@RequestBody HashMap<String, Object> requestData) {
		log.info("============ PRINTING PUBLISHED MESSAGE ON LISTENER 2 ==============");
		log.info(String.valueOf(requestData));
		log.info("============= DONE PRINTING ===========");

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
