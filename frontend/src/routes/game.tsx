import * as React from "react";
import { createFileRoute } from "@tanstack/react-router";
import GameContainer from "../components/game/gameContainer";

export const Route = createFileRoute("/game")({
  component: AboutComponent,
});

function AboutComponent() {
  return (
    <div className="p-2">
      <GameContainer />
    </div>
  );
}
