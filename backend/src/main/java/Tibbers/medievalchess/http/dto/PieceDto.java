package Tibbers.medievalchess.http.dto;

public record PieceDto(String type, String active, int hp, int maxHp, int owner) {
}
