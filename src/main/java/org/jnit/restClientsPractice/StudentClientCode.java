package org.jnit.restClientsPractice;

import java.util.Arrays;
import java.util.List;

import org.jnit.model.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StudentClientCode {
	public static final String REST_SERVICE_URI = "http://localhost:8080";
	
	private static void getStudents()
	{
	    final String uri = "http://localhost:8080/allStudents";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	     
	    System.out.println(result);
	}
	
	public static void getStudent(){
		final String uri="http://localhost:8080//oneStudent/slow";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 ResponseEntity<Student> result = restTemplate.exchange(uri, HttpMethod.GET, entity, Student.class);
	     
		    System.out.println(result);
	}
	
	/* GET restTemplate*/
    private static void getSimpleStudent(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(REST_SERVICE_URI+"/oneStudent/slow", Student.class);
        System.out.println(student);
    }
    
    private static void getSimpleStudents(){
    	System.out.println("Testing getSimpleStudent API----------");
    	RestTemplate restTemplate = new RestTemplate();
        List<Student> student = restTemplate.getForObject(REST_SERVICE_URI+"/allStudents", List.class);
        System.out.println(student);
    	
    }
	
	
	
	public static void main(String args[]){
		StudentClientCode.getStudents();
		StudentClientCode.getStudent();
		StudentClientCode.getSimpleStudent();
		StudentClientCode.getSimpleStudents();
	}

}
