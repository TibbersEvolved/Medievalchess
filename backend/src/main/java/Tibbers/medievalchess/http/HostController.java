package Tibbers.medievalchess.http;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    public HostGameDto buildHostGameDto(String name, UUID id) {
        return new HostGameDto(name, id.toString());
    }


}
