package com.primeiroprojetosb.FirstPSB;

import org.junit.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan(basePackages = "com.primeiroprojetosb.entities")
class FirstPsbApplicationTests {

	@Test
	void contextLoads() {
	}

}
