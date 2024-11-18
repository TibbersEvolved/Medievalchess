import { useState } from "react";
import GameCreateButton from "./gameCreate/gameCreateButton";
import GameSelect from "./gameSelect/gameSelect";
import GamePiece from "./gameActive/piece/tempPiece";
import Tile from "./gameActive/tile/tile";
import tileProp from "./gameActive/tile/tile";

export default function GameContainer() {
  const [activeGame, setActiveGame] = useState(0);
  const [selectedGame, setSelectedGame] = useState(0);
  const tiles = [];
  let key = -1;
  for (let i = 0; i < 8; i++) {
    for (let j = 0; j < 8; j++) {
      key += 1;
      let positions = {
        posX: i,
        posY: j,
      };
      tiles.push(positions);
    }
  }
  console.log(tiles);
  return (
    <>
      <section className="flex flex-col gap-5 ml-4">
        {" "}
        My games
        <GameSelect name="The First game" id="1" />
        <GameCreateButton />
        <div className="gameGrid">
          {tiles.map((prop, index) => {
            console.log(prop);
            return <Tile posX={prop.posX} posY={prop.posY} key={index} />;
          })}
        </div>
      </section>
    </>
  );
}
