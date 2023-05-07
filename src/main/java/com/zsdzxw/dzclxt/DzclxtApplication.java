package com.zsdzxw.dzclxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("com.zsdzxw.dzclxt.mapper")
@ComponentScan({"springfox.documentation.schema","com.zsdzxw.dzclxt.*"})
public class DzclxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DzclxtApplication.class, args);
	}

}
