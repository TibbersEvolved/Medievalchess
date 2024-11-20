import { useContext } from "react";
import { stateCallback } from "../../gameSelect/listGameSelect";
import { defaultSelectedTile } from "../gameboard";
import { webBuyUnit } from "../utilities/fetchCommands";
import ShopItem, { shopItemProduct } from "./shopItem";
import { selectCallback, tileCoordinates } from "./tile";
import { GameContext } from "../utilities/gameContext";
import { useQueryClient } from "@tanstack/react-query";

const productArcher: shopItemProduct = {
  type: "archer",
  cost: 20,
};
const productKnight: shopItemProduct = {
  type: "knight",
  cost: 30,
};
const productTorch: shopItemProduct = {
  type: "torch",
  cost: 15,
};

export default function Shop(prop: shopProp) {
  const gameId = useContext(GameContext);
  const client = useQueryClient();
  function handleClose() {
    prop.callbackClose(defaultSelectedTile);
  }
  async function handleBuy(item: shopItemProduct) {
    await webBuyUnit(
      prop.position.x,
      prop.position.y,
      item.type,
      prop.playerId,
      gameId
    );
    client.invalidateQueries({
      queryKey: ["boardGameInfo"],
      refetchType: "all",
    });

    client.invalidateQueries({
      queryKey: ["activeGame"],
      refetchType: "all",
    });
    prop.callbackClose(defaultSelectedTile);
  }

  return (
    <>
      <div className="z-50 ml-12 absolute flex flex-col gap-1 bg-base-300 px-1.5">
        <div>Shop</div>
        <ShopItem item={productArcher} callBack={handleBuy} />
        <ShopItem item={productKnight} callBack={handleBuy} />
        <ShopItem item={productTorch} callBack={handleBuy} />
        <button className="btn btn-warning btn-sm " onClick={handleClose}>
          Close
        </button>
      </div>
    </>
  );
}

type shopProp = {
  callbackClose: selectCallback;
  playerId: number;
  position: tileCoordinates;
};
