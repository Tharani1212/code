package com.mindtree.UserManagementController;

import java.io.IOException;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import com.mindtree.UserEntity.ResDetails;
import com.mindtree.UserEntity.Users;
import com.mindtree.UserManagementService.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RefreshScope
public class UserController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	 @Value("${url:Hello default}")
	    private String url;
	 
	 @RequestMapping("/url")
	    String getMessage() {
	        return this.url;
	    }
	 @KafkaListener(topics = "order", groupId = "group_id")
	    public void consume(String message) throws IOException {
	        logger.info(String.format("#### -> Consumed message -> %s", message));
	    }
	@PostMapping(value = "/UserDetails")
	public ResponseEntity<Users> insertusers(@RequestBody Users data) {

		Users res = userService.createUsers(data);

		return new ResponseEntity<Users>(res, HttpStatus.ACCEPTED);

	}

	@GetMapping(value = "/user/{uId}")
	@HystrixCommand(fallbackMethod="defaultMe")
	public ResponseEntity<Optional<Users>> getusers(@PathVariable("uId")  Integer uId) {

		Optional<Users> res = userService.RetrieveUsers(uId);

		return new ResponseEntity<Optional<Users>>(res, HttpStatus.ACCEPTED);

	}
	
	@GetMapping(value = "/user")
	@HystrixCommand(fallbackMethod="defaultsMe")
	public ResDetails getuser() {

		
	       System.out.println("URL" + url);
	       ResDetails emp = restTemplate.getForObject(url, ResDetails.class);
	       System.out.println("RESPONSE " + emp);
	       return emp;

	}
	
	private ResDetails defaultsMe(){
		ResDetails  info = new ResDetails();
	     
	      info.setLocation("Hystrix fallback");
	      info.setResName("Netfilx");
	      info.setResName("Fallback");
	     
	      return info;

	   }
	
	private ResponseEntity<Optional<Users>> defaultMe(Integer uId){
		 Users  info = new Users();
	      info.setUserId(uId);
	      info.setAddress("Hystrix fallback");
	      info.setUserName("Netfilx");
	      info.setPassword("Fallback");
	      Optional<Users> userOptional = Optional.of(info);
	      return new ResponseEntity<Optional<Users>>(userOptional, HttpStatus.ACCEPTED);

	   }
	
	@GetMapping(value = "/login")
	public ResponseEntity<Optional<Users>> login(@PathVariable("uId")  Integer uId) {

		Optional<Users> res = userService.RetrieveUsers(uId);

		return new ResponseEntity<Optional<Users>>(HttpStatus.ACCEPTED);

	}

	@PostMapping(value = "/UserDetails/{uId}/{password}/{oldpassword}")
	public ResponseEntity<Integer> updatePassword(@PathVariable("uId") Integer uId,
			@Min(6) @PathVariable("password")  String password,@PathVariable("oldpassword") String oldpassword) {

		Integer res = userService.upadatePassword(uId, password,oldpassword);

		return new ResponseEntity<Integer>(res, HttpStatus.ACCEPTED);

	}

}
