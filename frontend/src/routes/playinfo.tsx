import * as React from "react";
import { createFileRoute } from "@tanstack/react-router";
import GameInfoPlayer from "../components/game/gameSelect/gameInfoPlayer";
import GameInfo from "../components/game/gameSelect/gameInfo";
import PieceInfo from "../components/playinfo/pieceInfo";
import StructureInfo from "../components/playinfo/structureInfo";
import SiteFooter from "../components/root/siteFooter";

export const Route = createFileRoute("/playinfo")({
  component: HomeComponent,
});

function HomeComponent() {
  return (
    <div className="p-2 text-center">
      <h3 className="text-4xl">Game Mechanics</h3>
      <section className="mt-3 mx-10">
        Medieval Chess is a turn based game where each player takes turns to
        move their pieces. At the start of each turn you will gain gold to spend
        on buying new pieces. You can also move your pieces and attack enemy
        pieces. Each piece can only move and attack once per turn. To win a
        game, you must kill the enemy king. Different types of pieces have
        different strenghts and weaknesses.
      </section>
      <section className="mt-3 mx-10">
        The amount of gold you get each turn is based upon the number of
        villages and keeps you control. Each player starts with a few of those,
        but you can take over your opponents structures by moving your king on
        top of them! Be careful though, this puts your king at risk!
      </section>
      <header className="text-3xl mt-4 gap-10">List of Units</header>
      <section className="flex flex-row flex-wrap mx-10 justify-center">
        <PieceInfo
          title="Archer"
          text="Attacks enemies from afar."
          imageUrl="\assets\pieces\archer\archerBlue.png"
          hp={2}
          cost={20}
          range={2}
          move={1}
        />
        <PieceInfo
          title="Knight"
          text="Fast movement and can take a lot of hits. Strong versus archers"
          imageUrl="\assets\pieces\knight\knightRed.png"
          hp={3}
          cost={30}
          range={1}
          move={2}
        />
        <PieceInfo
          title="Torch"
          text="Can move in any direction. Good versus knights"
          imageUrl="\assets\pieces\torch\torchBlue.png"
          hp={2}
          cost={15}
          range={1}
          move={1}
        />
        <PieceInfo
          title="King"
          text="Can take over structures. If he dies, you lose!"
          imageUrl="\assets\pieces\king\kingRed.png"
          hp={4}
          cost={0}
          range={1}
          move={1}
        />
      </section>
      <header className="text-3xl mt-4 gap-10">List of Structures</header>
      <section className="flex flex-row flex-wrap mx-10 justify-center">
        <StructureInfo
          title="Keep"
          text="Provides 5 gold income. You can also buy units from here"
          imageUrl="/assets\structures\keep\keepBlue.png"
        />
        <StructureInfo
          title="Town"
          text="Provides 10 gold income."
          imageUrl="/assets\structures\house\houseRed.png"
        />
      </section>
    </div>
  );
}
