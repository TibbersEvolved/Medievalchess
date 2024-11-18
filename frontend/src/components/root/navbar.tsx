import { Link } from "@tanstack/react-router";

export default function Navbar() {
  return (
    <>
      {" "}
      <div className="p-2 flex justify-center gap-10 text-lg bg-info">
        <Link
          to="/game"
          activeProps={{
            className: "font-bold",
          }}
        >
          Games
        </Link>
        <Link
          to="/newGame"
          activeProps={{
            className: "font-bold",
          }}
        >
          New Game
        </Link>
        <Link
          to="/"
          activeProps={{
            className: "font-bold",
          }}
          activeOptions={{ exact: true }}
        >
          Home
        </Link>{" "}
      </div>
    </>
  );
}
