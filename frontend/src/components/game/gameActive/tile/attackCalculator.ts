import { tileProp } from "./tile";

export function calcAttack(data: tileProp): boolean {
  if (
    data.select.piece === "none" ||
    data.select.piece === "shop" ||
    data.select.active === 0 ||
    data.piece.type === "none" ||
    data.piece.owner === data.select.owner
  ) {
    return false;
  }
  const range = getAttackRange(data.select.piece);
  if (
    Math.abs(data.posX - data.select.xCord) <= range &&
    Math.abs(data.posY - data.select.yCord) <= range
  ) {
    return true;
  }
  return false;
}

function getAttackRange(piece: string): number {
  if (piece === "king") {
    return 1;
  }
  if (piece === "archer") {
    return 2;
  }
  if (piece === "torch") {
    return 1;
  }
  if (piece === "knight") {
    return 1;
  }
  return 0;
}
