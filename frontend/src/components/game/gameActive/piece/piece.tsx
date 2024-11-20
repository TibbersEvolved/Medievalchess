import { pieceType } from "../gameboard";

export default function GamePiece(props: pieceType) {
  const temp = [];
  for (let i = 0; i < props.hp; i++) {
    temp.push(i);
  }
  return (
    <>
      <img
        className="absolute piece z-40 mt-3 pointer-events-none"
        src={getPieceImage(props.type, props.owner)}
      ></img>
      <div className="flex flex-row mt-2 gap-1 pointer-events-none justify-center">
        {temp.map((t) => (
          <img
            key={t}
            className="size-2  pointer-events-none z-40 "
            src="src/assets/resources/hearth.png"
          ></img>
        ))}
      </div>
    </>
  );
}

function getPieceImage(type: string, owner: number) {
  if (type === "king") {
    if (owner === 0) {
      return "src/assets/pieces/king/kingblue.png";
    }
    return "src/assets/pieces/king/kingRed.png";
  }
  if (type === "archer") {
    if (owner === 0) {
      return "src/assets/pieces/archer/archerBlue.png";
    }
    return "src/assets/pieces/archer/archerRed.png";
  }
  if (type === "knight") {
    if (owner === 0) {
      return "src/assets/pieces/knight/knightBlue.png";
    }
    return "src/assets/pieces/knight/knightRed.png";
  }
  if (type === "torch") {
    if (owner === 0) {
      return "src/assets/pieces/torch/torchBlue.png";
    }
    return "src/assets/pieces/torch/torchRed.png";
  }
}
