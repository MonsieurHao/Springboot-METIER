package com.lsio.SpringbootMETIER.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lsio.SpringbootMETIER.entities.Game;
import com.lsio.SpringbootMETIER.entities.GameDTO;


@FeignClient(name="SPRINGBOOTDAO", configuration = FeignClientConfiguration.class)
public interface ServicesInterface{

    @GetMapping("/user/getgame/{id}")
    public Game getGameById(@PathVariable Long id);

    @GetMapping("/user/getgames")
    public List<Game> getGames();

    @PostMapping("/admin/addgame")
    public Game save(@RequestBody Game game);

    @GetMapping("/user/getgame/{name}")
    public Game getGameByName(@PathVariable String name);
    
    @GetMapping("/user/map")
    public List<GameDTO> getAllGamesDTO();
}

