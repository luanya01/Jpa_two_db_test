package com.example.jpatwodb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootTest
class JpatwdbApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder pe = new BCryptPasswordEncoder();
		String ecode = pe.encode("12345");
		System.out.println("ecode:" + ecode);
		boolean matches = pe.matches("12345", ecode);
		System.out.println("matches:" + matches);

//		System.out.println(Arrays.stream(new String[]{"a,b,c"})
//				.map(auth -> new SimpleGrantedAuthority(auth))
//				.collect(Collectors.toList()));
//
//		System.out.println(AuthorityUtils.commaSeparatedStringToAuthorityList("a,b,c"));
	}

}
