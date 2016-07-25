package com.estsoft.futures.aradongbros.travelfriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estsoft.futures.aradongbros.travelfriend.service.TrainService;

@Controller
@RequestMapping("/train")
public class TrainController 
{
	@Autowired
	private TrainService trainService;
}
