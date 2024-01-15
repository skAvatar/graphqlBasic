package com.training.graphQL.model;


import lombok.Builder;

@Builder
public record Player(Integer id, String name, Team team){

/*    public Player setValues(String name, Team team){
        return new Player(id, name, team);
    }*/

}
