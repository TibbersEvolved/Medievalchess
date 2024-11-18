package Tibbers.medievalchess.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameServiceTests {

    @Autowired
    private GameService gameService;

    @Test
    void shouldBeAbleToDeleteGame() {
        UUID game = gameService.startNewGame("Some name", "","");
        gameService.deleteGame(game.toString());

        assertEquals(0,gameService.getAllGames().size());
    }
}
