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
    console.log("Hey I did it!");
  }
  if (activeGame == 1)
    return (
      <>
        <GameBoard id={selectedGame} />
      </>
    );
  return (
    <>
      <section className="flex flex-col gap-4 ml-4">
        {" "}
        My games
        <ListGameSelect callback={handleModeChange} />
      </section>
    </>
  );
}
