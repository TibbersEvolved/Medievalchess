import { Link } from "@tanstack/react-router";

export default function Navbar() {
  return (
    <>
      {" "}
      <div className="p-2 flex justify-center gap-2 text-lg bg-info">
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
      </div>
    </>
  );
}
