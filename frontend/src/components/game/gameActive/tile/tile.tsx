import { useState } from "react";
import GamePiece from "../piece/tempPiece";

export default function Tile(prop: tileProp) {
  const [selected, changeSelected] = useState(false);
  return (
    <>
      <div>
        <img
          className="z-10 absolute"
          src="src/assets/tiles/grassTile.png"
          alt=""
          onClick={() => changeSelected(!selected)}
        />
        <GamePiece />
      </div>
    </>
  );
}

type tileProp = {
  posX: number;
  posY: number;
};
