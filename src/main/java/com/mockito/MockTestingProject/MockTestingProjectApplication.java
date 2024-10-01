package com.mockito.MockTestingProject;

import com.mockito.MockTestingProject.entity.Player;
import com.mockito.MockTestingProject.repository.PlayerRepositoryImpl;
import com.mockito.MockTestingProject.service.PlayerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockTestingProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(MockTestingProjectApplication.class, args);

		// Probar métodos
		/*

		PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();

		PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);

		System.out.println(playerService.findAll());

		System.out.println(playerService.findById(1L));

		Player newPlayer = new Player(7L, "Luis Diaz", "Delantero", "Liverpool");
		playerService.save(newPlayer);
		System.out.println(playerService.findAll());

		playerService.deleteById(1L);
		System.out.println(playerService.findAll());

		*/
	}

}
