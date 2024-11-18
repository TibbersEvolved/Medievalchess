import { playerData } from "./gameInfo";

export default function GameInfoPlayer(props: playerData) {
  return (
    <>
      <section className="flex flex-row gap-2 bg-primary p-1">
        <div>{props.name}</div>
        <div>Gold: {props.gold}</div>
      </section>
    </>
  );
}
