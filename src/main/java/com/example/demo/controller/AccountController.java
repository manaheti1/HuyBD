package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;

@RestController
@RequestMapping("/v2/api/account/")
public class AccountController {
	@GetMapping
	public List<Account> getAll() {
		return null;
	}

	@PostMapping
	public boolean register() {
		return false;
	}
}
