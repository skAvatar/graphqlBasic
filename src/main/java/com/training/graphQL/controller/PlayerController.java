package com.training.graphQL.controller;

import com.training.graphQL.model.Player;
import com.training.graphQL.model.Team;
import com.training.graphQL.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService service;

    @QueryMapping
    public List<Player> findAll(){
        return service.findAll();
    }

    @QueryMapping
    public Player findOne(@Argument Integer id){
        return service.findOne(id);
    }

    @MutationMapping
    public Player create(@Argument String name, @Argument Team team ){
        return service.create(name, team);
    }

    @MutationMapping
    public Player update(@Argument Integer id,@Argument String name, @Argument Team team ){
        return service.updateOne(id, name, team);
    }

    @MutationMapping
    public Player deleteOne(@Argument Integer id){
        return service.deleteOne(id);
    }



}
