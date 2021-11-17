package com.example.ClienteMicrometer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examble.ClienteMicrometer.model.States;
import com.example.ClienteMicrometer.services.StatusService;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class ClienteMicrometerApplication implements CommandLineRunner {

	@Autowired
	States a;
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteMicrometerApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		StatusService st = new StatusService();
		
		for(int i=0; i <= 5; i++) {
			a.writeOperation("Medioabierto");
			st.halfOpen();
			Thread.sleep(3000);
			if(i >= 3) {
				a.writeOperation("Cerrado");
				st.close();
				Thread.sleep(3000);
			} else {
				a.writeOperation("Abierto");
				st.close();
				Thread.sleep(3000);
			}
		}	
		
		
	}
}
	


