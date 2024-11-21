import { Link } from "@tanstack/react-router";

export default function Navbar() {
  return (
    <>
      {" "}
      <div className="p-2 flex justify-between text-lg bg-base-300 w-full shadow-inner shadow-slate-950">
        <section className="flex flex-row gap-10">
          <div className="font-bold">Medieval Chess</div>
          <img src="./src/assets/appIcon.png" className="size-8"></img>
        </section>
        <section className="flex flex-row gap-10 mr-36 ">
          <Link
            to="/"
            activeProps={{
              className: "font-bold",
            }}
            activeOptions={{ exact: true }}
          >
            Home
          </Link>{" "}
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
            to="/playinfo"
            activeProps={{
              className: "font-bold",
            }}
          >
            How to Play
          </Link>
        </section>
        <section>
          <div>Login</div>
        </section>
      </div>
    </>
  );
}
