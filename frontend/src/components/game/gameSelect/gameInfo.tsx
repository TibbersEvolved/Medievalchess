import { useQuery } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";
import GameInfoPlayer from "./gameInfoPlayer";

export default function GameInfo(props: prop) {
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

  return (
    <>
      <section className="flex flex-col gap-2 bg-base-200 p-3 rounded-sm min-w-80">
        <div className="font-extrabold">{typedData.gameName}</div>
        <div>Turn: {typedData.gameTurn}</div>
        {typedData.players.map((player, index) => {
          return (
            <GameInfoPlayer name={player.name} gold={player.gold} key={index} />
          );
        })}
        <button className="btn bg-base-300">Enter Game</button>
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
};

function fetchInfo(id: string) {
  return fetch(basepath + "hosts/" + id).then((res) => res.json());
}
