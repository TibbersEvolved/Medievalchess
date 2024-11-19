import { useState } from "react";
import GamePiece from "../piece/piece";
import { pieceType, structureType } from "../gameboard";
import Structure from "../structure/structure";

export default function Tile(prop: tileProp) {
  const [selected, changeSelected] = useState(false);
  return (
    <>
      <div>
        <img
          className="z-10 absolute"
          src="src/assets/tiles/grassTile.png"
          alt=""
        />
        {prop.structure.type != "none" && (
          <Structure owner={prop.structure.owner} type={prop.structure.type} />
        )}
        {prop.piece.type != "none" && (
          <GamePiece
            hp={prop.piece.hp}
            type={prop.piece.type}
            owner={prop.piece.owner}
            active={prop.piece.active}
          />
        )}
      </div>
    </>
  );
}

type tileProp = {
  posX: number;
  posY: number;
  structure: structureType;
  piece: pieceType;
};
