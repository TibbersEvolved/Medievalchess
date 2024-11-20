import { playerData } from "./gameInfo";

export default function GameInfoPlayer(props: playerData) {
  let color = "bg-primary";
  if (props.currentTurn) color = "bg-green-500 font-bold";
  return (
    <>
      <section className={"flex flex-row gap-2 p-1 rounded-sm " + color}>
        <div>{props.name}</div>
        <div>Gold: {props.gold}</div>
      </section>
    </>
  );
}
