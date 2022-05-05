package com.example.springbootmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootmybatisApplication implements CommandLineRunner {

	@Autowired
	private TestMapper testMapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmybatisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			while (true) {
				System.out.println(testMapper.getUserName());
				Thread.sleep(2);
			}
		} catch (Throwable e) {
			System.out.println("e.getClass()");
			printException(e.getClass());
			System.out.println("e.getCause().getClass()");
			printException(e.getCause().getClass());
		}
	}

	private void printException(Class<?> e) {
		String className = e.getCanonicalName();
		System.out.println(className);
		if (e.getSuperclass() != null) {
			printException(e.getSuperclass());
		}
	}
}
