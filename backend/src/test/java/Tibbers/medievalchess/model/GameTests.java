package Tibbers.medievalchess.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTests {

    @Test
    void shouldGainIncomeOnNewGame() {
        Game game = Game.newGame("test","","");
        game.endTurn();
        Player player = game.getPlayer(1);
        game.endTurn();
        Player player2 = game.getPlayer(0);
        assertEquals(10,player.getGold());
        assertEquals(10,player2.getGold());
    }

    @Test
    void shouldLoopPlayerTurns() {
        Game game = Game.newGame("test","","");
        game.endTurn();
        game.endTurn();
        assertEquals(0,game.getPlayerTurn());
    }
}
