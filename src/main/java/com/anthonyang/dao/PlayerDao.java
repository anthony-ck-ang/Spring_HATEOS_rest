package com.anthonyang.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.anthonyang.domain.Player;
import com.anthonyang.domain.Team;

//@RestResource is used to determine the name of the links
@RestResource(path="players", rel="players")
public interface PlayerDao extends CrudRepository<Player, Long>{
	

}
