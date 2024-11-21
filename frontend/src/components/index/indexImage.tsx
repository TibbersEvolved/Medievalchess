export default function IndexImage(prop: props) {
  return (
    <img className="size-36 shadow-md rounded-sm" src={prop.imageUrl}></img>
  );
}

type props = {
  imageUrl: string;
};
