package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingTestController {

	Logger logger = LoggerFactory.getLogger(LoggingTestController.class);

	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/")
	public String sayHello() {
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		for (int i = 0; i < 100; i++)
			logger.error("Error {}", i);
		return "Hello, World!";
	}

	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE, value = "/e")
	public String throwError() {
		try {
			error();
		} catch (IllegalAccessException e) {
			logger.error("", e);
		}
		return "Hello, World!";
	}

	private void error() throws IllegalAccessException {
		throw new IllegalAccessException("Bad state");
	}

}
