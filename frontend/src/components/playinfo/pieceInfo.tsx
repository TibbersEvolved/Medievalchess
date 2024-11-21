export default function PieceInfo(props: prop) {
  return (
    <>
      <section className="flex flex-row mt-4">
        <img src={props.imageUrl} className="size-24"></img>
        <div className="max-w-32">
          <header className="text-3xl">{props.title}</header>
          <div>{props.text}</div>
        </div>
      </section>
    </>
  );
}

type prop = {
  title: string;
  text: string;
  imageUrl: string;
};
