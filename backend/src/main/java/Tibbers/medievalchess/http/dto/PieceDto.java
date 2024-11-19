package Tibbers.medievalchess.http.dto;

public record PieceDto(String type, Boolean active, int hp, int owner) {
}
