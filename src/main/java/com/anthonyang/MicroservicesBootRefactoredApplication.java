package com.anthonyang;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.anthonyang.MicroservicesBootRefactoredApplication;
import com.anthonyang.dao.TeamDao;
import com.anthonyang.domain.Player;
import com.anthonyang.domain.Team;

@SpringBootApplication
public class MicroservicesBootRefactoredApplication extends SpringBootServletInitializer{

	/**
	 * Used when run as JAR
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootRefactoredApplication.class, args);
	}
	
	/**
	 * Used when run as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	
		return builder.sources(MicroservicesBootRefactoredApplication.class);
	}
	
	@Autowired TeamDao teamDao;
	
	@PostConstruct //this will be executed when it starts
	public void init(){
		Set<Player> players = new HashSet<>();
		players.add(new Player("Charlie Brown", "pitcher"));
		players.add(new Player("Snoopy", "shortstop"));
		
		Team team = new Team("California", "Peanuts", players);
		teamDao.save(team);
		
		Set<Player> players2 = new HashSet<>();
		players2.add(new Player("John Dan", "pitcher"));
		players2.add(new Player("loopy", "shortstop"));
		
		Team team2 = new Team("Singapore", "Macadamia", players2);
		teamDao.save(team2);
	}
	
	
}
