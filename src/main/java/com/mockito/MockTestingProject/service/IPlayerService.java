package com.mockito.MockTestingProject.service;

import com.mockito.MockTestingProject.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();

    Player findById(Long id);

    void save(Player player);

    void deleteById(Long id);
}
