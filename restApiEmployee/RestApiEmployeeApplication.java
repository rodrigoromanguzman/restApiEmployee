package com.example.restApiEmployee;

import com.example.restApiEmployee.entity.Employee;
import com.example.restApiEmployee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiEmployeeApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(EmployeeRepository employeeRepo){
		return args -> {
			employeeRepo.save(new Employee("John","Doe","john@email.com"));
			employeeRepo.save(new Employee("Jane","Roberts","jane@email.com"));
		};
	}
}
