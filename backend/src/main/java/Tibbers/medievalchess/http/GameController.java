package Tibbers.medievalchess.http;

import Tibbers.medievalchess.http.dto.ActiveGame.ActiveGameDto;
import Tibbers.medievalchess.http.dto.ActiveGame.PieceDto;
import Tibbers.medievalchess.http.dto.ActiveGame.StructureDto;
import Tibbers.medievalchess.http.dto.ActiveGame.TileDto;
import Tibbers.medievalchess.http.dto.Request.RequestAttackDto;
import Tibbers.medievalchess.http.dto.Request.RequestBuyDto;
import Tibbers.medievalchess.http.dto.Request.RequestMoveDto;
import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.model.Tile;
import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Structure;
import Tibbers.medievalchess.service.GameService;
import Tibbers.medievalchess.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameController {

    private HostService hostService;
    private GameService gameService;
    private Comparator<TileDto> sorter;

    public GameController(HostService hostService, GameService gameService) {
        this.hostService = hostService;
        this.gameService = gameService;
        sorter = Comparator.comparing(tile -> tile.yCord());
        sorter = sorter.thenComparing(tile -> tile.xCord());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActiveGameDto> getGame(@PathVariable String id) {
        Game game = hostService.getGameById(UUID.fromString(id));
        List<TileDto> list = getTileDtoList(game);
        List<TileDto> l2 = list.stream().sorted(sorter).toList();
        ActiveGameDto output = new ActiveGameDto(l2);
     return ResponseEntity.ok(output);
    }

    @PostMapping("/endTurn/{id}")
    public ResponseEntity endGameTurn(@PathVariable String id) {
        gameService.endGameTurn(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("move/{id}")
    public ResponseEntity movePiece(@PathVariable String id, @RequestBody RequestMoveDto moveRequest) {
        if (gameService.movePiece(UUID.fromString(id),
                moveRequest.xFrom(),moveRequest.yFrom(),moveRequest.xTo(),moveRequest.yTo()))
        return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("buy/{id}")
    public ResponseEntity buyPiece(@PathVariable String id, @RequestBody RequestBuyDto buyRequest) {
        if (gameService.buyUnit(UUID.fromString(id), buyRequest.x(),
                buyRequest.y(), buyRequest.type(), buyRequest.playerId()))
            return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("attack/{id}")
    public ResponseEntity attackPiece(@PathVariable String id, @RequestBody RequestAttackDto attackDto) {
        if (gameService.damagePiece(attackDto.x(), attackDto.y(),
                attackDto.xTo(), attackDto.yTo(), UUID.fromString(id)))
            return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }



    private ActiveGameDto getGameDtoFromGame(Game game) {
        List<TileDto> tileDtoList = new ArrayList<>();
        List<Tile> tiles = game.getTiles();
        for(int i = 0; i < tiles.size(); i++) {
            {
                Tile t = tiles.get(i);
                PieceDto piece = buildPieceDto(t);
                StructureDto structure = buildStructureDto(t);
                tileDtoList.add(new TileDto(t.getX(),t.getY(),piece,structure));
            }
        }
        return new ActiveGameDto(tileDtoList);
    }

    private List<TileDto> getTileDtoList(Game game) {
        List<TileDto> tileDtoList = new ArrayList<>();
        List<Tile> tiles = game.getTiles();
        for(int i = 0; i < tiles.size(); i++) {
            {
                Tile t = tiles.get(i);
                PieceDto piece = buildPieceDto(t);
                StructureDto structure = buildStructureDto(t);
                tileDtoList.add(new TileDto(t.getX(),t.getY(),piece,structure));
            }
        }
        return tileDtoList;
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
