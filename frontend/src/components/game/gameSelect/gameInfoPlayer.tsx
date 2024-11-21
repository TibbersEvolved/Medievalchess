import { playerData } from "./gameInfo";

export default function GameInfoPlayer(props: playerData) {
  let color = "shadow-md bg-primary font-normal";
  if (props.currentTurn) color = "bg-base-100 shadow-md font-bold";
  return (
    <>
      <section className={"flex flex-col gap-2 p-1 rounded-sm " + color}>
        <div>{props.name}</div>
        <div>Gold: {props.gold}</div>
      </section>
    </>
  );
}
