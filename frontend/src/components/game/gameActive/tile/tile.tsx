import GamePiece from "../piece/piece";
import { gameBoardSelectedTile, pieceType, structureType } from "../gameboard";
import Structure from "../structure/structure";
import { calcMovement } from "./moveCalculator";

export default function Tile(prop: tileProp) {
  const canMove = calcMovement(prop);
  async function handleSelect() {
    if (prop.select.piece === "shop") {
      return;
    }
    if (canMove) {
      prop.moveCallback({ x: prop.posX, y: prop.posY });
    } else {
      prop.callback({
        xCord: prop.posX,
        yCord: prop.posY,
        piece: prop.piece.type,
        active: prop.piece.active,
      });
    }
  }
  return (
    <>
      <div>
        <img
          className="z-10 absolute"
          src="src/assets/tiles/grassTile.png"
          alt=""
          onClick={handleSelect}
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
        {canMove && (
          <img
            className="z-20 piece absolute pointer-events-none"
            src="src/assets/tiles/selectTile.png"
            alt=""
          />
        )}
      </div>
    </>
  );
}

export type tileProp = {
  posX: number;
  posY: number;
  structure: structureType;
  piece: pieceType;
  select: gameBoardSelectedTile;
  callback: selectCallback;
  moveCallback: moveCallback;
};

export interface selectCallback {
  (e: gameBoardSelectedTile): void;
}

export type tileCoordinates = {
  x: number;
  y: number;
};

export interface moveCallback {
  (e: tileCoordinates): void;
}
