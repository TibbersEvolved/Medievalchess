package Tibbers.medievalchess.repository;

import Tibbers.medievalchess.model.Game;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameDbRepository extends ListCrudRepository<Game, UUID> {
}
