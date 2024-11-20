import { structureType } from "../gameboard";

export default function Structure(props: structureType) {
  return (
    <img
      className="absolute piece z-30 pointer-events-none"
      src={getStructureImage(props.type, props.owner)}
    ></img>
  );
}

function getStructureImage(type: string, owner: number) {
  if (type === "keep") {
    if (owner === 0) {
      return "src/assets/structures/keep/keepBlue.png";
    }
    return "src/assets/structures/keep/keepRed.png";
  }
  if (type === "town") {
    if (owner === 0) {
      return "src/assets/structures/house/houseBlue.png";
    }
    return "src/assets/structures/house/houseRed.png";
  }
}
