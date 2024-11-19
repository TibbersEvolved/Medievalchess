import { useQuery } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";
import Tile from "./tile/tile";

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
  const tiles: tileType[] = data.tiles;
  console.log(tiles);
  return (
    <>
      <div>Game Loaded</div>
      <section className="mx-auto w-fit">
        <section className="gameGrid">
          {tiles.map((tile, index) => {
            return <Tile posX={tile.xCord} posY={tile.yCord} />;
          })}
        </section>
      </section>
    </>
  );
}

function fetchInfo(id: string) {
  return fetch(basepath + "games/" + id).then((res) => res.json());
}

type boardProp = {
  id: string;
};

type pieceType = {
  active: boolean;
  hp: number;
  owner: number;
  type: string;
};

type structureType = {
  owner: number;
  type: string;
};

type tileType = {
  piece: pieceType;
  structure: structureType;
  xCord: number;
  yCord: number;
};
