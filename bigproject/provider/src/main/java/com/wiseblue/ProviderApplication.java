package com.wiseblue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = "com.wiseblue.dao")
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
		System.out.println("服务发布成功...");
		try {
			System.in.read();//让程序阻塞
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
