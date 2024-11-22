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
      return "/assets/structures/keep/keepBlue.png";
    }
    return "/assets/structures/keep/keepRed.png";
  }
  if (type === "town") {
    if (owner === 0) {
      return "/assets/structures/house/houseBlue.png";
    }
    return "/assets/structures/house/houseRed.png";
  }
}
