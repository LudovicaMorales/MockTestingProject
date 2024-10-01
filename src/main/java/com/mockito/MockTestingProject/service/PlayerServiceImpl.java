package com.mockito.MockTestingProject.service;

import com.mockito.MockTestingProject.entity.Player;
import com.mockito.MockTestingProject.repository.PlayerRepositoryImpl;

import java.util.List;

public class PlayerServiceImpl implements IPlayerService{

    private PlayerRepositoryImpl playerRepository;

    public PlayerServiceImpl(PlayerRepositoryImpl playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return this.playerRepository.findById(id);
    }

    @Override
    public void save(Player player) {
        this.playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        this.playerRepository.deleteById(id);
    }
}