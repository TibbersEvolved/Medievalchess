import * as React from "react";
import { createFileRoute } from "@tanstack/react-router";
import GameInfoPlayer from "../components/game/gameSelect/gameInfoPlayer";
import GameInfo from "../components/game/gameSelect/gameInfo";
import IndexImage from "../components/index/indexImage";

export const Route = createFileRoute("/")({
  component: HomeComponent,
});

function HomeComponent() {
  return (
    <div className="p-2 text-center">
      <h3 className="text-4xl">Welcome to Medieval Chess!</h3>
      <section className="mt-3 mx-5">
        Overview: Dive into the thrilling world of Medieval Chess, a turn-based
        strategy game that combines the tactical depth of chess with the dynamic
        resource management of a medieval battlefield. Plan your moves, control
        key territories, and expand your army to overthrow your opponent’s king.
        Each turn is a chance to gain an edge or fall prey to a cunning
        counterattack. Will you risk your king to claim vital resources, or will
        you build an impenetrable fortress? The choice is yours.
      </section>
      <section className="flex flex-row gap-8 justify-center mt-3">
        <IndexImage imageUrl="\assets\index\gameshot1.png" />
        <IndexImage imageUrl="\assets\index\gameshot2.png" />
        <IndexImage imageUrl="\assets\index\gameshot3.png" />
        <IndexImage imageUrl="\assets\index\gameshot4.png" />
      </section>
      <section className="mt-4 mx-5">
        <div className="font-bold text-lg">Features</div>
        <div className="font-bold">Strategic Turns:</div>
        <div>
          Each player alternates turns, making critical decisions to strengthen
          their position. In every turn, you can move your pieces, attack enemy
          units, or deploy reinforcements.
        </div>
        <div className="font-bold">Gold Generation & Spending:</div>
        <div>
          Your income grows based on the number of villages and keeps you
          control. Use gold to recruit new units from an expanding roster of
          medieval troops. Choose wisely—your gold is limited, and every
          purchase counts.
        </div>
        <div className="font-bold">Territory Control:</div>
        <div>
          Villages and keeps are your lifeblood, generating the gold you need to
          dominate. Move your king onto an enemy-controlled structure to claim
          it as your own. Defend your territories to deny your opponent valuable
          resources.
        </div>
      </section>
    </div>
  );
}
