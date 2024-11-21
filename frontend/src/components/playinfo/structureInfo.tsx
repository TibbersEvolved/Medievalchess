export default function StructureInfo(props: prop) {
  return (
    <section className="flex flex-row mt-4">
      <img src={props.imageUrl} className="size-24"></img>
      <div className="max-w-32">
        <div className="text-3xl">{props.title}</div>
        <div>{props.text}</div>
      </div>
    </section>
  );
}

type prop = {
  imageUrl: string;
  title: string;
  text: string;
};
