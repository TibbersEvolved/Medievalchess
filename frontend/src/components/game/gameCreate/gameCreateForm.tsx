import { useState } from "react";
import { basepath } from "../../../utilities/backendPaths";
import { serverMessage } from "../gameActive/utilities/toasts";

export default function GameCreateForm() {
  async function handlePost(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    const input = e.currentTarget;
    const data: dto = {
      gameName: (input.elements[0] as HTMLInputElement).value,
      player1: (input.elements[1] as HTMLInputElement).value,
      player2: (input.elements[2] as HTMLInputElement).value,
    };
    createGame(data);
  }

  return (
    <>
      <div className="mx-auto w-fit">
        <form className="flex flex-col gap-3" onSubmit={(e) => handlePost(e)}>
          <label>Game Name:</label>
          <input type="text"></input>
          <label>Player 1 Name:</label>
          <input type="text"></input>
          <label>Player 2 Name:</label>
          <input type="text"></input>
          <button className="btn btn-primary" type="submit">
            Create Game
          </button>
        </form>
      </div>
    </>
  );
}

type dto = {
  gameName: string;
  player1: string;
  player2: string;
};

async function createGame(data: dto) {
  const response = await fetch(basepath + "hosts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json; charset=utf-8",
    },
    body: JSON.stringify(data),
  });
  const statusCode = response.status.toString();
  if (statusCode === "200") {
    serverMessage(data.gameName + " was created!", 0);
    return;
  }
}
