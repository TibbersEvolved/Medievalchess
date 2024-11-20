package Tibbers.medievalchess.repository;

import Tibbers.medievalchess.model.Tile;
import org.springframework.data.repository.ListCrudRepository;

public interface TileRepository extends ListCrudRepository<Tile, Long> {
}
