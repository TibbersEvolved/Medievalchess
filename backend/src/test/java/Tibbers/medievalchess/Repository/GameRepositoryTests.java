package Tibbers.medievalchess.Repository;

import Tibbers.medievalchess.repository.GameRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameRepositoryTests {
    GameRepository repository = new GameRepository();

    @Test
    void shouldCreateNewGameAndFindItById() {
        UUID gameid = repository.startNewGame("test","","");
        assertNotEquals(null,repository.findGameById(gameid));
    }


}
