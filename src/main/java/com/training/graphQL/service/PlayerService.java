package com.training.graphQL.service;

import com.training.graphQL.model.Player;
import com.training.graphQL.model.Team;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    AtomicInteger id = new AtomicInteger(0);

    public List<Player> findAll(){
        return players;
    }

    public Player findOne(Integer id){
        return players.stream()
            .filter(player -> player.id().equals(id))
            .findFirst().orElse(null);
    }

    public Player create(String name, Team team){
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);

        return player;
    }

    public Player updateOne(Integer id,String name, Team team){
        Player uptatedPlayer = new Player(id, name, team);

        players.set(id - 1, uptatedPlayer);

        return uptatedPlayer;
    }



    public Player deleteOne(Integer id) {
        Player player = players.stream()
            .filter(p -> p.id().equals(id))
            .findFirst().orElse(null);
        players.remove(player);
        return player;
    }

    @PostConstruct
    private void init(){
        players.add(new Player(id.incrementAndGet(), "Jose Altuve", Team.NAV));
        players.add(new Player(id.incrementAndGet(), "Richard Hidalgo", Team.NAV));
        players.add(new Player(id.incrementAndGet(), "Johan Santana", Team.NAV));
        players.add(new Player(id.incrementAndGet(), "Edgar Alfonso", Team.NAV));
        players.add(new Player(id.incrementAndGet(), "Tapon Hernandez", Team.NAV));
        players.add(new Player(id.incrementAndGet(), "Toro Zambrano", Team.NAV));
        players.add(new Player(id.incrementAndGet(), "Luis Jimenez", Team.LAR));
        players.add(new Player(id.incrementAndGet(), "Jorge CROGER", Team.LEO));
        players.add(new Player(id.incrementAndGet(), "Kid Rodriguez", Team.TIB));
        players.add(new Player(id.incrementAndGet(), "Henry Blanco", Team.LEO));



    }






}
