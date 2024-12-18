import { useQuery, useQueryClient } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";
import GameInfoPlayer from "./gameInfoPlayer";
import { stateCallback } from "./listGameSelect";
import { webDeleteGame } from "../gameActive/utilities/fetchCommands";

export default function GameInfo(props: prop) {
  const client = useQueryClient();
  const { isPending, isError, data, error } = useQuery({
    queryKey: ["gameInfo", props.id],
    queryFn: () => fetchInfo(props.id),
  });

  if (isPending) {
    return <span>Loading...</span>;
  }

  if (isError) {
    return <span>Error: {error.message}</span>;
  }
  const typedData: gameData = data;
  async function handleDelete() {
    await webDeleteGame(props.id);
    client.invalidateQueries({
      queryKey: ["listGameSelect"],
      refetchType: "all",
    });
    props.callbackDelete();
  }

  return (
    <>
      <section className="flex flex-col gap-2 bg-base-200 p-3 rounded-sm min-w-80 shadow-md">
        <div className="font-extrabold">{typedData.gameName}</div>
        <div className="font-normal">Turn: {typedData.gameTurn}</div>
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
        <button
          className="btn bg-base-300 text-lg shadow-sm"
          onClick={props.cb}
        >
          Enter Game
        </button>
        <button
          className="btn btn-warning text-lg shadow-sm"
          onClick={handleDelete}
        >
          Abandon Game
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
  currentTurn: boolean;
};

type prop = {
  id: string;
  cb: stateCallback;
  callbackDelete: stateCallback;
};

function fetchInfo(id: string) {
  return fetch(basepath + "hosts/" + id).then((res) => res.json());
}
