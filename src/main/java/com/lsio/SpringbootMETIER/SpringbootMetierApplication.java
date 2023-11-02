package com.lsio.SpringbootMETIER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootMetierApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMetierApplication.class, args);
	}

}
