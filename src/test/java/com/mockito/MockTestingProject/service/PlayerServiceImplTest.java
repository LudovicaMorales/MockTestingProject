package com.mockito.MockTestingProject.service;

import com.mockito.MockTestingProject.DataProvider;
import com.mockito.MockTestingProject.entity.Player;
import com.mockito.MockTestingProject.repository.PlayerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    @Mock
    private PlayerRepositoryImpl playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;


    @Test
    public void testFindAll(){

        // When

        when(playerRepository.findAll()).thenReturn(DataProvider.playerListMock());

        List<Player> result = playerService.findAll();

        // Then

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Lionel Messi", result.get(0).getName());
        assertEquals("Inter Miami", result.get(0).getTeam());
        assertEquals("Delantero", result.get(0).getPosition());
        verify(this.playerRepository).findAll();

    }

    @Test
    public void testFindById(){

        // Given

        Long id = 7L;

        // When

        when(playerRepository.findById(anyLong())).thenReturn(DataProvider.playerMock());
        Player player = this.playerService.findById(id);

        // Then

        assertNotNull(player);
        assertEquals("Lionel Messi", player.getName());
        assertEquals("Inter Miami", player.getTeam());
        assertEquals("Delantero", player.getPosition());
        verify(this.playerRepository).findById(anyLong());
    }

    @Test
    public void testSave(){

        // Given

        Player newPlayer = DataProvider.newPlayerMock();

        // When

        this.playerService.save(newPlayer);

        // Then

        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).save(playerCaptor.capture());
        verify(this.playerRepository).save(any(Player.class));
        assertEquals(8L, playerCaptor.getValue().getId());
        assertEquals("Luisa Morales", playerCaptor.getValue().getName());
        assertEquals("Colombia selection", playerCaptor.getValue().getTeam());
        assertEquals("Arquera", playerCaptor.getValue().getPosition());
    }

    @Test
    public void testDelete() {

        // Given

        Long id = 7L;

        // When

        this.playerService.deleteById(id);

        // Then

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById(anyLong());
        verify(this.playerRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(7L, longArgumentCaptor.getValue());
    }
}
