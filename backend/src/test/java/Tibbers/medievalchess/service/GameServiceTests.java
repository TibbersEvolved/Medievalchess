package Tibbers.medievalchess.service;

import Tibbers.medievalchess.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GameServiceTests {

    @Autowired
    private GameService gameService;
    @Autowired
    private HostService hostService;
    @Test
    void shouldEndTurn() {
        UUID id = hostService.startNewGame("TestGame","MockPlayer","Mock2");
        gameService.endGameTurn(id);
        Game game = hostService.getGameById(id);
        assertEquals(1,game.getTurn());
    }
}
