package com.lsio.SpringbootMETIER;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsio.SpringbootMETIER.entities.Game;
import com.lsio.SpringbootMETIER.entities.GameDTO;
import com.lsio.SpringbootMETIER.feign.ServicesInterface;

@RestController
public class ServicesController {

    @Autowired
    private ServicesInterface services;

    @GetMapping("/user/getgames")
    public ResponseEntity<List<Game>> getGames(){
        return new ResponseEntity<>(services.getGames(), HttpStatus.OK);
    }

    @PostMapping("/admin/addgame")
    public ResponseEntity<String> saveGame(@RequestBody Game game){
        services.save(game);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/user/getgame/{name}")
    public ResponseEntity<Game> getGame(@PathVariable String gameName){
        return new ResponseEntity<Game>(services.getGameByName(gameName),HttpStatus.OK);
    }

    @GetMapping("/user/getgame/{id}")
    public ResponseEntity<Game> getGameWithID(Long id){
        return new ResponseEntity<Game>(services.getGameById(id),HttpStatus.OK);
    }
    
    private GameDTO convertGameIntoDTO(Game game){
        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setName(game.getGamename());
        dto.setEditor(game.getGameeditor());
        return dto;
    }

    @GetMapping("/user/map")
    public List<GameDTO> getAllGamesDTO(){
        return ((List<Game>)services
                .getGames())
                .stream()
                .map(this::convertGameIntoDTO)
                    .collect(Collectors.toList());
    }
    
    
}
