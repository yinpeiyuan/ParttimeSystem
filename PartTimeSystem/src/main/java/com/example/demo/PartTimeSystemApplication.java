package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.mapper")
@ComponentScan(basePackages= {"com.example.demo", "org.n3r.idworker"})
public class PartTimeSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartTimeSystemApplication.class, args);
	}

}

