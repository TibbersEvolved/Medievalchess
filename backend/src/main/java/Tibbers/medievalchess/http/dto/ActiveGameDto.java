package Tibbers.medievalchess.http.dto;

import java.util.List;

public record ActiveGameDto(List<TileDto> tiles) {
}
