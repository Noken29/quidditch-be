package com.noken.quidditchbe.api;

import com.noken.quidditchbe.domain.Player;
import com.noken.quidditchbe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(value = "/get-all", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Player>> getAll() {
        return new ResponseEntity<>(playerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(playerRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> saveAll(@RequestBody Player player) {
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

    @PostMapping(value = "/save-all", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Player>> saveAll(@RequestBody List<Player> players) {
        return new ResponseEntity<>(playerRepository.saveAll(players), HttpStatus.OK);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Player> update(@RequestBody Player player) {
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

}
