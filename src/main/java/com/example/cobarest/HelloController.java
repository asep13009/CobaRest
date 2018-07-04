package com.example.cobarest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Greeting;
import com.example.model.Quote;
import com.example.model.TampungGreeting;

@RestController
public class HelloController {
	
	private static final String greet="Hello,%s";
	final AtomicLong counter = new AtomicLong();	
	@RequestMapping("/helo")
	public String tesHello() {
		return "hello!";
	}
	@RequestMapping("/greeting")
	public Greeting getGreeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),String.format(greet, name),"tes");
	}
	@RequestMapping("/tesTampung")
	public TampungGreeting tesTampung() {
		RestTemplate restTemplate= new RestTemplate();
		TampungGreeting tampung =restTemplate.getForObject
				("http://localhost:8080/greeting", TampungGreeting.class);
		return tampung;
	}
	@RequestMapping("/tesQuote")
	public Quote tesQuote() {
		RestTemplate restTemplate= new RestTemplate();
		Quote quote =restTemplate.getForObject
				("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote;
	}
	
}
