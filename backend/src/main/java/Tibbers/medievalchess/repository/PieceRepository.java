package Tibbers.medievalchess.repository;

import Tibbers.medievalchess.model.piece.Piece;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends ListCrudRepository<Piece,Long> {
}
