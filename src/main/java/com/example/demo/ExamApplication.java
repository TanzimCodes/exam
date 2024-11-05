package com.example.demo;

import com.example.demo.controller.GardenController;
import com.example.demo.entity.Garden;
import com.example.demo.entity.Plant;
import com.example.demo.service.GardenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Hello");
//
//		Garden garden1  = new Garden(1L,"Vegetable Patch",50.00,null);
//		Garden garden2 = new Garden(2L,"Herb Garden",20.00,null);
//
//
//		GardenService gardenService = new GardenService();
//		gardenService.create(garden1);
//		gardenService.create(garden2);


	}
}
