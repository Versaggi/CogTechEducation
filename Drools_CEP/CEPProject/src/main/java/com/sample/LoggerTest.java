package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	public static void main(String[] args) {
	    Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	    logger.info("Logger Test");

	}
}
