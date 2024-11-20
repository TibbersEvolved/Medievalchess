export default function ShopItem(prop: shopItemProps) {
  return (
    <button
      className="btn bg-base-200 btn-sm"
      onClick={() => prop.callBack(prop.item)}
    >
      {prop.item.type} {prop.item.cost} gold
    </button>
  );
}

type shopItemProps = {
  item: shopItemProduct;
  callBack: shopCall;
};

export type shopItemProduct = {
  cost: number;
  type: string;
};

interface shopCall {
  (prod: shopItemProduct): void;
}
