package Tibbers.medievalchess.http;

import Tibbers.medievalchess.http.dto.TileDto;
import Tibbers.medievalchess.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/games")
public class GameController {

    private HostService hostService;

    @GetMapping("/{id}")
    public ResponseEntity<TileDto> getGame(@PathVariable String id) {
     return null;
    }
}
