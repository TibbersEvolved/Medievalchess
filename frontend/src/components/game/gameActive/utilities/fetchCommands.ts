import { basepath } from "../../../../utilities/backendPaths";

export async function webEndTurn(id: string) {
  return fetch(basepath + "games/endTurn/" + id, { method: "POST" });
}
