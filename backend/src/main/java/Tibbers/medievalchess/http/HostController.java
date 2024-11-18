package Tibbers.medievalchess.http;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hosts")
public class HostController {

    private GameService gameService;

    public HostController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<UUID> startNewGame(@PathVariable String name) {
        return ResponseEntity.ok(gameService.startNewGame(name));
    }

    @GetMapping
    public ResponseEntity<ListHostGameDto> getAllGames() {
        List<Game> games = gameService.getAllGames();
        List<HostGameDto> listDto = games.stream()
                .map(s -> buildHostGameDto(s.getGameName(),s.getGameId()))
                .toList();
        return ResponseEntity.ok(new ListHostGameDto(listDto));
    }


    public HostGameDto buildHostGameDto(String name, UUID id) {
        return new HostGameDto(name, id.toString());
    }


}
