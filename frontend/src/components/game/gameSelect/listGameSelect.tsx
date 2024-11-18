import { useQuery, useQueryClient } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";
import GameSelect from "./gameSelect";
import { useState } from "react";
import GameInfo from "./gameInfo";

export default function ListGameSelect() {
  const [selectId, setSelectId] = useState("");
  const [selected, setSelected] = useState(false);
  function handleSelect(e: string) {
    setSelectId(e);
    setSelected(true);
  }
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
      <section className="flex flex-row gap-16">
        <div className="flex flex-col gap-4">
          {newdata.map((res) => {
            return (
              <GameSelect
                name={res.name}
                id={res.id}
                key={res.id}
                cb={() => handleSelect(res.id)}
              />
            );
          })}
        </div>
        {selected && <GameInfo id={selectId} />}
      </section>
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
