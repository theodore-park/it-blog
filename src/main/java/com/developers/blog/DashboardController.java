package com.developers.blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

	@GetMapping("/")
	public String dashboard() {
		return "Hello Developers Blog!";
	}
}
