import { useQuery } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";
import GameSelect from "./gameSelect";

export default function ListGameSelect() {
  const { isPending, isError, data, error } = useQuery({
    queryKey: ["todos"],
    queryFn: fetchGames,
  });

  if (isPending) {
    return <span>Loading...</span>;
  }

  if (isError) {
    return <span>Error: {error.message}</span>;
  }

  const newdata: fetchData[] = data.games;

  return (
    <>
      {newdata.map((res) => {
        return <GameSelect name={res.name} id={res.id} key={res.id} />;
      })}
    </>
  );
}

function fetchGames() {
  return fetch(basepath + "hosts").then((res) => res.json());
}

type fetchData = {
  name: string;
  id: string;
};
