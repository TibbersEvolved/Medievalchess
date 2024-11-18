export default function GameSelect(prop: type_gameInfo) {
  return (
    <>
      <button className="btn btn-primary btn-xs w-32">{prop.name}</button>
    </>
  );
}

type type_gameInfo = {
  name: string;
  id: string;
};
