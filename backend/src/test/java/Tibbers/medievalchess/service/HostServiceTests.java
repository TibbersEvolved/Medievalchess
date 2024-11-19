package Tibbers.medievalchess.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HostServiceTests {

    @Autowired
    private HostService hostService;

    @Test
    void shouldBeAbleToDeleteGame() {
        UUID game = hostService.startNewGame("Some name", "","");
        hostService.deleteGame(game.toString());

        assertEquals(0, hostService.getAllGames().size());
    }
}
