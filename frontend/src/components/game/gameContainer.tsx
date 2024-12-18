import { useState } from "react";
import GameCreateButton from "./gameCreate/gameCreateButton";
import GameSelect from "./gameSelect/gameSelect";
import GamePiece from "./gameActive/piece/piece";
import Tile from "./gameActive/tile/tile";
import tileProp from "./gameActive/tile/tile";
import ListGameSelect from "./gameSelect/listGameSelect";
import GameBoard from "./gameActive/gameboard";

export default function GameContainer() {
  const [activeGame, setActiveGame] = useState(0);
  const [selectedGame, setSelectedGame] = useState("");

  function handleModeChange(input: string) {
    setSelectedGame(input);
    setActiveGame(1);
  }
  if (activeGame == 1)
    return (
      <>
        <div className="mb-20">
          <GameBoard id={selectedGame} />
        </div>
      </>
    );
  return (
    <>
      <section className="flex flex-col gap-4 ml-4 text-xl font-bold">
        {" "}
        My games
        <ListGameSelect callback={handleModeChange} />
      </section>
    </>
  );
}
