import { useQuery } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";

export default function GameBoard(props: boardProp) {
  const { isPending, isError, data, error } = useQuery({
    queryKey: ["activeGame", props.id],
    queryFn: () => fetchInfo(props.id),
  });

  if (isPending) {
    return <span>Loading...</span>;
  }

  if (isError) {
    return <span>Error: {error.message}</span>;
  }

  return (
    <>
      <div>Game Loaded</div>
    </>
  );
}

function fetchInfo(id: string) {
  return fetch(basepath + "games/" + id).then((res) => res.json());
}

type boardProp = {
  id: string;
};
