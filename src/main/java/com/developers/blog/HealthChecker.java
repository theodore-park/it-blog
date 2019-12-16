package com.developers.blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthChecker {

	@GetMapping("/hello")
	public String healthCheck() {
		return "OK";
	}
}
