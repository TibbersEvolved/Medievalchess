package Tibbers.medievalchess.http;

import Tibbers.medievalchess.http.dto.*;
import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.model.Tile;
import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Structure;
import Tibbers.medievalchess.service.GameService;
import Tibbers.medievalchess.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameController {

    private HostService hostService;
    private GameService gameService;

    public GameController(HostService hostService, GameService gameService) {
        this.hostService = hostService;
        this.gameService = gameService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiveGameDto> getGame(@PathVariable String id) {
        Game game = hostService.getGameById(UUID.fromString(id));
     return ResponseEntity.ok(getGameDtoFromGame(game));
    }

    @PostMapping("/endTurn/{id}")
    public ResponseEntity endGameTurn(@PathVariable String id) {
        gameService.endGameTurn(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("move/{id}")
    public ResponseEntity movePiece(@PathVariable String id, @RequestBody MoveRequestDto moveRequest) {
        if (gameService.movePiece(UUID.fromString(id),moveRequest.xFrom(),moveRequest.yFrom(),moveRequest.xTo(),moveRequest.yTo()))
        return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }



    private ActiveGameDto getGameDtoFromGame(Game game) {
        List<TileDto> tileDtoList = new ArrayList<>();
        Tile[][] tiles = game.getTiles();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                PieceDto piece = buildPieceDto(tiles[i][j]);
                StructureDto structure = buildStructureDto(tiles[i][j]);
                tileDtoList.add(new TileDto(j,i,piece,structure));
            }
        }
        return new ActiveGameDto(tileDtoList);
    }

    private PieceDto getEmptyPieceDto() {
        return new PieceDto("none",0,0,0);
    }

    private StructureDto getEmptyStructureDto() {
        return new StructureDto(0,"none");
    }

    private PieceDto buildPieceDto(Tile tile) {
        Piece p = tile.getPiece();
        if(p == null){
            return getEmptyPieceDto();
        }
        return new PieceDto(p.getType(),p.isActive(),p.getHp(),p.getPlayer().getTurnId());
    }

    private StructureDto buildStructureDto(Tile tile) {
        Structure t = tile.getStructure();
        if(t == null) {
            return getEmptyStructureDto();
        }
        return new StructureDto(t.getPlayer().getTurnId(),t.getType());
    }
}
