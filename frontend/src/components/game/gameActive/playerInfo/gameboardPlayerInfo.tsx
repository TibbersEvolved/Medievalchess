import { useQuery } from "@tanstack/react-query";
import { basepath } from "../../../../utilities/backendPaths";
import GameInfoPlayer from "../../gameSelect/gameInfoPlayer";
import { stateCallback } from "../../gameSelect/listGameSelect";
import { webEndTurn } from "../utilities/fetchCommands";
import { endTurnToast } from "../utilities/toasts";

export default function GameBoardPlayerInfo(props: prop) {
  const { isPending, isError, data, error } = useQuery({
    queryKey: ["boardGameInfo", props.id],
    queryFn: () => fetchInfo(props.id),
  });

  if (isPending) {
    return <span>Loading...</span>;
  }

  if (isError) {
    return <span>Error: {error.message}</span>;
  }
  const typedData: gameData = data;
  async function endTurn() {
    await webEndTurn(props.id);
    let name = "";
    for (let i = 0; i < typedData.players.length; i++) {
      if (i != typedData.playerTurn) {
        name = typedData.players[i].name;
      }
    }
    endTurnToast(name + "'s turn!");
    props.cb();
  }

  return (
    <>
      <section className="flex flex-col gap-2 bg-base-200 p-3 rounded-sm min-w-60">
        <div className="font-extrabold">{typedData.gameName}</div>
        <div>{typedData.players[typedData.playerTurn].name}'s turn</div>
        <div>Turn: {typedData.gameTurn}</div>
        {typedData.players.map((player, index) => {
          return (
            <GameInfoPlayer
              name={player.name}
              gold={player.gold}
              key={index}
              currentTurn={typedData.playerTurn == index}
            />
          );
        })}
        <button className="btn bg-warning mt-2 shadow-md" onClick={endTurn}>
          End Turn
        </button>
      </section>
    </>
  );
}

type gameData = {
  gameName: string;
  players: playerData[];
  gameTurn: number;
  playerTurn: number;
};

export type playerData = {
  name: string;
  gold: string;
};

type prop = {
  id: string;
  cb: stateCallback;
};

function fetchInfo(id: string) {
  return fetch(basepath + "hosts/" + id).then((res) => res.json());
}
