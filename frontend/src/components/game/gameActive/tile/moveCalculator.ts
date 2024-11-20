import { tileProp } from "./tile";

export function calcMovement(data: tileProp): boolean {
  if (
    data.select.piece === "none" ||
    data.select.piece === "shop" ||
    data.select.active === 0
  ) {
    return false;
  }
  if (data.select.xCord == data.posX && data.select.yCord == data.posY) {
    return false;
  }
  const piece = getPieceInfo(data.select.piece);
  const x = data.select.xCord;
  const y = data.select.yCord;
  if (piece.type === "any") {
    if (
      Math.abs(data.posX - x) <= piece.movement &&
      Math.abs(data.posY - y) <= piece.movement
    ) {
      return true;
    }
  }
  if (piece.type === "straight") {
    if (data.posX === x && Math.abs(data.posY - y) <= piece.movement) {
      return true;
    }
    if (data.posY === y && Math.abs(data.posX - x) <= piece.movement) {
      return true;
    }
  }
  return false;
}

function getPieceInfo(piece: string): pieceInfo {
  if (piece === "king") {
    return {
      movement: 1,
      type: "any",
    };
  }
  if (piece === "archer") {
    return {
      movement: 1,
      type: "straight",
    };
  }
  if (piece === "torch") {
    return {
      movement: 1,
      type: "any",
    };
  }
  if (piece === "knight") {
    return {
      movement: 1,
      type: "straight",
    };
  }

  return {
    movement: 0,
    type: "none",
  };
}

type pieceInfo = {
  movement: number;
  type: string;
};
