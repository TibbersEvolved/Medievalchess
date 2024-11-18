import * as React from "react";
import { createFileRoute } from "@tanstack/react-router";
import GameContainer from "../components/game/gameContainer";
import GameCreateForm from "../components/game/gameCreate/gameCreateForm";

export const Route = createFileRoute("/newGame")({
  component: NewGame,
});

function NewGame() {
  return (
    <div className="p-2">
      <GameCreateForm />
    </div>
  );
}
