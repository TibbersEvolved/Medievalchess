import { useState } from "react";
import GameCreateButton from "./gameCreate/gameCreateButton";
import GameSelect from "./gameSelect/gameSelect";
import GamePiece from "./gameActive/piece/tempPiece";
import Tile from "./gameActive/tile/tile";
import tileProp from "./gameActive/tile/tile";
import ListGameSelect from "./gameSelect/listGameSelect";

export default function GameContainer() {
  const [activeGame, setActiveGame] = useState(0);
  const [selectedGame, setSelectedGame] = useState(0);
  return (
    <>
      <section className="flex flex-col gap-4 ml-4">
        {" "}
        My games
        <ListGameSelect />
      </section>
    </>
  );
}
