package com.exam;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalServerApplication implements CommandLineRunner {
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("testing");

//		User user = new User();
//		user.setFirstname("Suryadutta");
//		user.setLastname("Dash");
//		user.setEmail("surayduttadash@gmail.com");
//		user.setPassword(bCryptPasswordEncoder.encode("Lipun@335"));
//		user.setPhone("7978627916");
//		user.setProfile("1.jpg");
//		user.setUsername("sdsurya335");
//
//		Role role = new Role();
//		role.setRoleName("ADMIN");
//		role.setRoleId(44L);
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());

	}
}
