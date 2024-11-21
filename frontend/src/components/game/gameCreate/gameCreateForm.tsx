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
    if (data.gameName.length <= 3) {
      serverMessage("Game name must be larger than 3 letters", 1);
      return;
    }
    if (data.player1.length <= 0) {
      serverMessage("Player names cannot be empty!", 1);
      return;
    }
    if (data.player2.length <= 0) {
      serverMessage("Player names cannot be empty!", 1);
      return;
    }
    e.currentTarget.reset();
    createGame(data);
  }

  return (
    <>
      <div className="mx-auto mt-3 w-fit  p-6 rounded-sm boardForm">
        <form className="flex flex-col gap-2 " onSubmit={(e) => handlePost(e)}>
          <div className="text-2xl text-base-100">Create New Game</div>
          <label className="text-center text-base-100">Game Name:</label>
          <input className="rounded-md " type="text"></input>
          <label className="text-center text-base-100">Player 1 Name:</label>
          <input className="rounded-md" type="text"></input>
          <label className="text-center text-base-100">Player 2 Name:</label>
          <input className="rounded-md" type="text"></input>
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
