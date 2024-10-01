package com.mockito.MockTestingProject.repository;

import com.mockito.MockTestingProject.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements IPlayerRepository{

    private List<Player> playerData = new ArrayList<>(List.of(
            new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"),
            new Player(2L, "Cristiano Ronaldo", "Al Nassr", "Delantero"),
            new Player(3L, "Neymar Jr.", "Paris Saint-Germain", "Delantero"),
            new Player(4L, "Kylian Mbappé", "Paris Saint-Germain", "Delantero"),
            new Player(5L, "Kevin De Bruyne", "Manchester City", "Volante"),
            new Player(6L, "Virgil van Dijk", "Liverpool", "Defensa")
    ));

    @Override
    public List<Player> findAll() {
        System.out.println("findAll REAL");
        return this.playerData;
    }

    @Override
    public Player findById(Long id) {
        System.out.println("findById REAL");
        return this.playerData.stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void save(Player player) {
        System.out.println("save REAL");
        this.playerData.add(player);

    }

    @Override
    public void deleteById(Long id) {
        System.out.println("deleteById REAL");
        this.playerData = this.playerData.stream()
                .filter(player -> player.getId() != id)
                .toList();
    }
}
