package com.example.UserApi;

import com.example.UserApi.Repositories.UsuarioRepostoryInterface;
import com.example.UserApi.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class UserApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}


}
