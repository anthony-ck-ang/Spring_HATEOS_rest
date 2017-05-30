package com.anthonyang.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.anthonyang.domain.Team;

@RestResource(path="teams", rel="teams") //path to expose eg. /teams, rel-> links generated
public interface TeamDao extends CrudRepository<Team, Long>{
	
	//Spring will auto implement
	List<Team> findAll();
	
	//convention: findBy<field><operation>
	//operation = Eq, Lt, Gt, Like, Between
	
	//Team findByLocation(String location);
	
	//team object has a field called "name"
	Team findByName(String name);
}
