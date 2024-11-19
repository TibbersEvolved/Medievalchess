import { useQuery } from "@tanstack/react-query";
import { basepath } from "../../../utilities/backendPaths";
import Tile from "./tile/tile";
import GameBoardPlayerInfo from "./gameboardPlayerInfo";
import { useState } from "react";

export default function GameBoard(props: boardProp) {
  const [updateGame, setUpdateGame] = useState(0);
  const { isPending, isError, data, error } = useQuery({
    queryKey: ["activeGame", updateGame],
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
      <section className="mx-auto w-fit flex flex-row">
        <section className="gameGrid">
          {tiles.map((tile, index) => {
            return (
              <Tile
                posX={tile.xCord}
                posY={tile.yCord}
                piece={tile.piece}
                structure={tile.structure}
              />
            );
          })}
        </section>
        <GameBoardPlayerInfo id={props.id} />
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

export type pieceType = {
  active: boolean;
  hp: number;
  owner: number;
  type: string;
};

export type structureType = {
  owner: number;
  type: string;
};

type tileType = {
  piece: pieceType;
  structure: structureType;
  xCord: number;
  yCord: number;
};
