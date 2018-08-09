package com.relay42.axoncomplaintsstatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AxonComplaintsStatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonComplaintsStatisticsApplication.class, args);
		System.out.println("Axon Statistics is Up");
	}
}
