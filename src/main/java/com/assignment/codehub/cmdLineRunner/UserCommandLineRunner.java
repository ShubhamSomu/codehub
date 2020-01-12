package com.assignment.codehub.cmdLineRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.assignment.codehub.CodehubApplication;
import com.assignment.codehub.configuration.FakerConfig;
import com.assignment.codehub.model.Role;
import com.assignment.codehub.model.User;
import com.assignment.codehub.service.RolesService;
import com.assignment.codehub.service.UserService;
import com.github.javafaker.Faker;


@Component
@Order(1)
public class UserCommandLineRunner implements CommandLineRunner{
	private Logger logger = LoggerFactory.getLogger(CodehubApplication.class);
	@Value("${mock.count}")
	private Integer mockCount;
	
	@Autowired
	FakerConfig fakerConfig;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService rolesService;
	
	private List<User> listOfUsers;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		fakerInsertUser();
		logger.debug("Loaded "+mockCount+" user objects in DB!!!!");
	}
	
	 private  void fakerInsertUser() {
		 Faker faker = fakerConfig.getfakerConfig();
			if(mockCount==null|| mockCount == 0)
				mockCount = 6;
			listOfUsers = new LinkedList<User>();
			for(int i=0;i<mockCount;i++) {
	/*			if(new Random().ints(0,2).limit(1).findFirst().
						getAsInt()  )
					fakeUser =true;
				else*/
				HashSet <Role> role =  new HashSet<Role>();
				role.add(Role.builder().role("ADMIN").build());
				User user=User.builder().fullName(faker.name().fullName().replace(" ", ""))
						.company(faker.company().name())
						.type(new Random().ints(0,2).limit(1).findFirst().
								getAsInt()==0 ? 1:2 )
						.fake(new Random().ints(0,2).limit(1).findFirst().
								getAsInt()==0 ? true:false).
						deleted(new Random().ints(0,2).limit(1).findFirst().
								getAsInt()==0 ? true:false )
						.longitude(Double.parseDouble(faker.address().longitude()))
						.latitude(Double.parseDouble(faker.address().latitude()))
						.countrycode(
								Integer.parseInt(
										faker.phoneNumber().cellPhone().substring(0, 
												new Random().ints(2,4).limit(1).findFirst().getAsInt())
										.trim().replace("-", "").replace("(", "")))
						.state(faker.address().state())
						.city(faker.address().city())
						.created_at(LocalDateTime.now())
						.password("password")
						.role(role)
						.build();

				userService.createAUser(user);
				
			}
			
			HashSet <Role> role2 =  new HashSet<Role>();
			role2.add(Role.builder().role("ADMIN").build());
			User user2 = User.builder().fullName("shubham")
			.company(faker.company().name())
			.type(new Random().ints(0,2).limit(1).findFirst().
					getAsInt()==0 ? 1:2 )
			.fake(new Random().ints(0,2).limit(1).findFirst().
					getAsInt()==0 ? true:false).
			deleted(new Random().ints(0,2).limit(1).findFirst().
					getAsInt()==0 ? true:false )
			.longitude(Double.parseDouble(faker.address().longitude()))
			.latitude(Double.parseDouble(faker.address().latitude()))
			.countrycode(
					Integer.parseInt(
							faker.phoneNumber().cellPhone().substring(0, 
									new Random().ints(2,4).limit(1).findFirst().getAsInt())
							.trim().replace("-", "").replace("(", "")))
			.state(faker.address().state())
			.city(faker.address().city())
			.created_at(LocalDateTime.now())
			.password("shubham")
			.role(role2)
			.build();
			userService.createAUser(user2);
	 }
	 
	private void fakeInsertRoles() {
		 Faker faker = fakerConfig.getfakerConfig();
		 List<String> rolesList = List.of("ADMIN","USER");
			if(mockCount==null|| mockCount == 0)
				mockCount = 6;
			for(int i=0;i<2;i++) {
					Role role = Role.builder().role(rolesList.
							get(new Random().ints(0,2).
									limit(1).findFirst().getAsInt())).build();
					rolesService.createRole(role);
			}
			
	}

}
