package Tibbers.MedievalChess.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private Tile[][] tiles;
    private UUID gameId;
    private List<Player> playerList = new ArrayList<>();


    public static Game newGame() {
        Game game = new Game();
        game.playerList.add(new Player());
        game.playerList.add(new Player());
        game.tiles = game.getDefaultGameSettings();
        return game;
    }

    public Game() {
        this.gameId = UUID.randomUUID();
    }


    private Tile[][] getDefaultGameSettings() {
        Tile[][] tiles = new Tile[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                tiles[i][j] = new Tile();
            }
        }
        return tiles;
    }

}
