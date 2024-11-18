package Tibbers.medievalchess.game;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.model.Player;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTests {

    @Test
    void shouldGainIncomeOnNewGame() {
        Game game = Game.newGame();
        game.endTurn();
        Player player = game.getPlayer(1);
        assertEquals(10,player.getGold());
    }
}
