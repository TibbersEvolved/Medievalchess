package Tibbers.medievalchess.http;

import Tibbers.medievalchess.http.dto.ActiveGameDto;
import Tibbers.medievalchess.http.dto.PieceDto;
import Tibbers.medievalchess.http.dto.StructureDto;
import Tibbers.medievalchess.http.dto.TileDto;
import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.model.Tile;
import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Structure;
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

    public GameController(HostService hostService) {
        this.hostService = hostService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiveGameDto> getGame(@PathVariable String id) {
        Game game = hostService.getGameById(UUID.fromString(id));
     return ResponseEntity.ok(getGameDtoFromGame(game));
    }



    private ActiveGameDto getGameDtoFromGame(Game game) {
        List<TileDto> tileDtoList = new ArrayList<>();
        Tile[][] tiles = game.getTiles();
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                PieceDto piece = buildPieceDto(tiles[i][j]);
                StructureDto structure = buildStructureDto(tiles[i][j]);
                tileDtoList.add(new TileDto(i,j,piece,structure));
            }
        }
        return new ActiveGameDto(tileDtoList);
    }

    private PieceDto getEmptyPieceDto() {
        return new PieceDto("none",false,0,0);
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
