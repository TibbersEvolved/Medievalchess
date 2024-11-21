export default function PieceInfo(props: prop) {
  const temp = [];
  for (let i = 0; i < props.hp; i++) {
    temp.push(i);
  }
  return (
    <>
      <section className="flex flex-row mt-4">
        <img src={props.imageUrl} className="size-24"></img>
        <div className="max-w-32">
          <header className="text-3xl">{props.title}</header>
          <div className="flex flex-row mt-2 gap-1 pointer-events-none justify-center">
            {temp.map((t) => (
              <img
                key={t}
                className="size-3"
                src="src/assets/resources/hearth.png"
              ></img>
            ))}
          </div>
          <section className="flex flex-row  justify-center">
            <div className="mx-1">{props.cost}</div>
            <img className="size-5" src="src\assets\resources\gold.png"></img>
            <div>{props.move}</div>
            <img className="size-5" src="src\assets\resources\speed.png"></img>
            <div className="mx-1">{props.range}</div>
            <img
              className="size-5"
              src="src\assets\resources\attackRange.png"
            ></img>
          </section>
          <div className="mx-1">{props.text}</div>
        </div>
      </section>
    </>
  );
}

type prop = {
  title: string;
  text: string;
  imageUrl: string;
  hp: number;
  cost: number;
  range: number;
  move: number;
};
