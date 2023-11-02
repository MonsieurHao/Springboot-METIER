package com.lsio.SpringbootMETIER.services;

import java.util.stream.Collectors;

import java.util.*;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsio.SpringbootMETIER.entities.Game;
import com.lsio.SpringbootMETIER.entities.GameDTO;
import com.lsio.SpringbootMETIER.feign.ServicesInterface;

@Service
public class GameMapper {

    private ServicesInterface gameRepo;

    
    public List<GameDTO> getAllGamesDTO(){
        return ((List<Game>)gameRepo
                .getGames())
                .stream()
                .map(this::convertGameIntoDTO)
                    .collect(Collectors.toList());
    }


    private GameDTO convertGameIntoDTO(Game game){
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setName(game.getGamename());
        dto.setEditor(game.getGameeditor());
        return dto;
    }
}
