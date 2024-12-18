import { basepath } from "../../../../utilities/backendPaths";
import { serverMessage } from "./toasts";

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
  console.log(
    "Sending request with id: " + id,
    "And body: " +
      payload.xTo +
      "/" +
      payload.yTo +
      " from" +
      payload.xFrom +
      "/" +
      payload.yFrom
  );
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

export async function webAttackUnit(payload: AttackRequest, gameId: string) {
  console.log("Attack request with payload:", payload);
  return fetch(basepath + "games/attack/" + gameId, {
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=utf-8",
    },
    body: JSON.stringify(payload),
  });
}

export async function webDeleteGame(gameId: string) {
  const respone = await fetch(basepath + "hosts/" + gameId, {
    method: "DELETE",
  });
  const statusCode = respone.status.toString();
  if (statusCode === "200") {
    serverMessage("Game was deleted!", 0);
    return;
  }
  serverMessage(
    "Something went wrong, server responded with code: " + statusCode,
    1
  );
}

export type AttackRequest = {
  x: number;
  y: number;
  xTo: number;
  yTo: number;
};
