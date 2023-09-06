package com.sm.controller;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sm.binding.User;

@RestController
public class CourseRestController {
	private HashOperations<String, Integer, User> hashOps;

	public CourseRestController(RedisTemplate<String, User> redisTemplate) {
		hashOps = redisTemplate.opsForHash();
	}

	@PostMapping("/store")
	public String stotrData(@RequestBody User user) {
		hashOps.put("Persons", user.getUid(), user);
		return "Success";
	}

	@GetMapping("/getData/{uid}")
	public User getData(@PathVariable Integer uid) {
		User person = hashOps.get("Persons",uid);

		return person;
	}
	
	@GetMapping("/users")
	public List<User>getAllUsers(){
		return hashOps.values("Persons");
	}
	
}
