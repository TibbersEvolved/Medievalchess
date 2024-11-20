import { basepath } from "../../../../utilities/backendPaths";

export async function webEndTurn(id: string) {
  return fetch(basepath + "games/endTurn/" + id, { method: "POST" });
}

export async function webPieceMove(
  id: string,
  x: number,
  y: number,
  xTo: number,
  yTo: number
) {
  const payload = {
    xFrom: x,
    yFrom: y,
    xTo: xTo,
    yTo: yTo,
  };
  return fetch(basepath + "games/move/" + id, {
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=utf-8",
    },
    body: JSON.stringify(payload),
  });
}

export async function webBuyUnit(
  x: number,
  y: number,
  type: string,
  playerId: number,
  gameId: string
) {
  const payload = {
    x: x,
    y: y,
    type: type,
    playerId: playerId,
  };
  return fetch(basepath + "games/buy/" + gameId, {
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=utf-8",
    },
    body: JSON.stringify(payload),
  });
}
