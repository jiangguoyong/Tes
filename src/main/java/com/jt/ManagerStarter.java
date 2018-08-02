package com.jt;

import java.util.Queue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
@MapperScan("com.jt.manage.mapper")
public class ManagerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ManagerStarter.class, args);
	}

}
