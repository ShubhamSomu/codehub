package com.assignment.codehub.cmdLineRunner;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.assignment.codehub.configuration.FakerConfig;
import com.assignment.codehub.model.User;
import com.assignment.codehub.service.UserService;
import com.github.javafaker.Faker;


@Component
@Order(1)
public class UserCommandLineRunner implements CommandLineRunner{
	
	@Value("${mock.count}")
	private Integer mockCount;
	
	@Autowired
	FakerConfig fakerConfig;
	
	@Autowired
	private UserService userService;
	
	private List<User> listOfUsers;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		fakerInsertUser();
		System.err.println("Loaded "+mockCount+" user objects in DB!!!!");
	}
	
	 private  void fakerInsertUser() {
		 Faker faker = fakerConfig.getfakerConfig();
			if(mockCount==null|| mockCount == 0)
				mockCount = 6;
			boolean fakeUser = false; 
			listOfUsers = new LinkedList<User>();
			for(int i=0;i<mockCount;i++) {
	/*			if(new Random().ints(0,2).limit(1).findFirst().
						getAsInt()  )
					fakeUser =true;
				else*/
				User user = new User(faker.name().fullName(),
						faker.company().name(),
						LocalDateTime.now(), 
						new Integer(new Random().ints(0,2).limit(1).findFirst().
						getAsInt()==0 ? 1:2) ,
								
						new Boolean(new Random().ints(0,2).limit(1).findFirst().
						getAsInt()==0 ? true:false),
								
						new Boolean(new Random().ints(0,2).limit(1).findFirst().
						getAsInt()==0 ? true:false),
								
						new Double(Double.parseDouble(faker.address().latitude())),
						new Double(Double.parseDouble(faker.address().longitude())),
						Integer.parseInt(
								faker.phoneNumber().cellPhone().substring(0, 
										new Random().ints(2,4).limit(1).findFirst().getAsInt())
								.trim().replace("-", "").replace("(", "")),
						faker.address().state(),
						faker.address().city(), new String(""));
				userService.createAUser(user);
				
			}
	 }

}
