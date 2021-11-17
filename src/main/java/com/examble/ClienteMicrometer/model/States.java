package com.examble.ClienteMicrometer.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = "estados")
public class States {
	
	private List<String> estados = new ArrayList<>();
	
	@ReadOperation
	public List<String> Estados(){
		return estados;
	}
	
	@WriteOperation
	public void writeOperation(@Selector String nuevoe){
		estados.add(nuevoe);
	}
	
	
	@DeleteOperation
	public void deleteOperation(@Selector String nuevoe){
		estados.remove(nuevoe);
	}
	
	
	

}
