package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;

@RestController
@RequestMapping("/v2/api/account/")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping
	public List<Account> getAll() {
		System.out.println("ok em oi");
		List<Account> list=new ArrayList<>();
		list.add(new Account());
		return list;
	}

	@PostMapping
	public boolean register() {
		return false;
	}
}
