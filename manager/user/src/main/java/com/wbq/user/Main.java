package com.wbq.user;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
  *
  * @author biqin.wu
  * @since 02 九月 2018
  */
@SpringBootApplication
@MapperScan(basePackages = "com.wbq.user.dao")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
