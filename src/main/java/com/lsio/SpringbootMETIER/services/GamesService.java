package com.lsio.SpringbootMETIER.services;

import java.util.*;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lsio.SpringbootMETIER.entities.Game;
import com.lsio.SpringbootMETIER.feign.ServicesInterface;

@Service
public class GamesService {
    
    
    ServicesInterface gameRepository;

    public GamesService(){

    }

    public ResponseEntity<List<Game>> getGames(){
        try{
            return new ResponseEntity<List<Game>>(gameRepository.getGames(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<Game>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> saveGame(Game game){
        gameRepository.save(game);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public Game getGame(String gameName) {
        return gameRepository.getGameByName(gameName);
    }

    public ResponseEntity<Game> getGameWithID(Long id) {
        Game game = gameRepository.getGameById(id);
        return new ResponseEntity<Game>(game, HttpStatus.OK);
    }
    
}
