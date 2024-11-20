import GamePiece from "../piece/piece";
import {
  defaultSelectedTile,
  gameBoardSelectedTile,
  pieceType,
  structureType,
} from "../gameboard";
import Structure from "../structure/structure";
import { calcMovement } from "./moveCalculator";
import Shop from "./shop";
import { calcAttack } from "./attackCalculator";
import { useContext } from "react";
import { GameContext } from "../utilities/gameContext";
import { webAttackUnit } from "../utilities/fetchCommands";
import { useQueryClient } from "@tanstack/react-query";

export default function Tile(prop: tileProp) {
  const selected =
    prop.posX == prop.select.xCord && prop.posY == prop.select.yCord;
  const client = useQueryClient();
  const gameId = useContext(GameContext);
  let canMove = false;
  let canAttack = calcAttack(prop);
  if (canAttack == false) {
    canMove = calcMovement(prop);
  }
  let displayShop = false;
  const cords: tileCoordinates = {
    x: prop.posX,
    y: prop.posY,
  };
  if (canMove == false && prop.select.piece === "shop" && selected) {
    displayShop = true;
  }

  async function handleSelect() {
    if (prop.select.piece === "shop") {
      return;
    }
    if (canAttack) {
      await webAttackUnit(
        {
          x: prop.select.xCord,
          y: prop.select.yCord,
          xTo: prop.posX,
          yTo: prop.posY,
        },
        gameId
      );
      client.invalidateQueries({
        queryKey: ["activeGame"],
        refetchType: "all",
      });
      prop.callback(defaultSelectedTile);
      return;
    }
    if (canMove) {
      await prop.moveCallback({ x: prop.posX, y: prop.posY });
      return;
    }
    let selectType = prop.piece.type;
    if (selectType == "none" && prop.structure.type == "keep") {
      selectType = "shop";
    }
    prop.callback({
      xCord: prop.posX,
      yCord: prop.posY,
      piece: selectType,
      active: prop.piece.active,
      owner: prop.piece.owner,
    });
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
        {canMove && (
          <img
            className="z-20 piece absolute pointer-events-none"
            src="src/assets/tiles/selectTile.png"
            alt=""
          />
        )}
        {canAttack && (
          <img
            className="z-20 piece absolute pointer-events-none"
            src="src/assets/tiles/attackTile.png"
            alt=""
          />
        )}
        {prop.piece.type != "none" && (
          <GamePiece
            hp={prop.piece.hp}
            type={prop.piece.type}
            owner={prop.piece.owner}
            active={prop.piece.active}
          />
        )}
        {displayShop && (
          <Shop
            callbackClose={prop.callback}
            playerId={prop.structure.owner}
            position={cords}
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
