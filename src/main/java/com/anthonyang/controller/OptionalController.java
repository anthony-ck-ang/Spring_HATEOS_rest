package com.anthonyang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthonyang.dao.TeamDao;
import com.anthonyang.domain.Team;
import com.anthonyang.exception.TeamNotFoundException;

@RestController
public class OptionalController {
	
	@Autowired
	TeamDao teamDao;
	
	@RequestMapping("/custom-search/{name}")
	public Team findByName(@PathVariable String name) {
		Team team = teamDao.findByName(name);
		if( team == null ){
			throw new TeamNotFoundException("Team with name: " + name + " not found.");
		}
		return teamDao.findByName(name);
	}
	
//	@RequestMapping("/custom-search/{location}")
//	public Team findByLocation(@PathVariable String location) {
//		return teamDao.findByLocation(location);
//	}
	
 	@RequestMapping("/custom-search/all")
 	public List<Team> findByName() {
 		return teamDao.findAll();
 	}
	
	

}
