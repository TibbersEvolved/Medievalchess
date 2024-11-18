package Tibbers.medievalchess.http.dto;

import java.util.List;

public record HostGameDetailedDto(String gameName, List<PlayerDto> players, int gameTurn, int playerTurn) {
}
