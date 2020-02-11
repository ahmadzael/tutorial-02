package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value="name")String name,Model model) {
		model.addAttribute("name",name);
		return "hello2";
	}

	
	@RequestMapping("/hello2/{name}")
	public String helloPath(@PathVariable String name,Model model) {
		model.addAttribute("name",name);
		return "hello2";
	} 
	
	/*
	@RequestMapping(value= {"/hello2", "/hello2/{name}"})
	public String helloPath(@PathVariable Optional<String> name,Model model) {
		if (name.isPresent()) {
			model.addAttribute("name",name.get());
		} else {
			model.addAttribute("name","phoenix");
		}
		return "hello2";
	} 
	*/
	
	@RequestMapping("/calc/{value1}/{value2}")
	public String Calc(@PathVariable int value1, @PathVariable int value2,Model model){
		int result;
		result = value1 + value2;
		model.addAttribute("value1",value1);
		model.addAttribute("value2",value2);
		model.addAttribute("result",result);
		return "calc";
	}
	
}
