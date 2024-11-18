package Tibbers.medievalchess.http;

import Tibbers.medievalchess.http.dto.*;
import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/hosts")
public class HostController {

    private GameService gameService;

    public HostController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping()
    public ResponseEntity<UUID> startNewGame(@RequestBody HostCreateGameDto dto) {
        return ResponseEntity.ok(gameService
                .startNewGame(dto.gameName(), dto.player1(), dto.player2()));
    }

    @GetMapping
    public ResponseEntity<ListHostGameDto> getAllGames() {
        List<Game> games = gameService.getAllGames();
        List<HostGameDto> listDto = games.stream()
                .map(s -> buildHostGameDto(s.getGameName(),s.getGameId()))
                .toList();
        return ResponseEntity.ok(new ListHostGameDto(listDto));
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameService.deleteGame(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HostGameDetailedDto> getDetailedGameInfo(@PathVariable String id) {
        Game game = gameService.getGameById(UUID.fromString(id));
        List<PlayerDto> players = new ArrayList<>();
        players.add(new PlayerDto
                (game.getPlayer(0).getName(),game.getPlayer(0).getGold()));
        players.add(new PlayerDto
                (game.getPlayer(1).getName(),game.getPlayer(1).getGold()));
        HostGameDetailedDto output = new HostGameDetailedDto(game.getGameName(),
                players,game.getTurn(), game.getPlayerTurn());
        return ResponseEntity.ok(output);
    }


    public HostGameDto buildHostGameDto(String name, UUID id) {
        return new HostGameDto(name, id.toString());
    }

}
