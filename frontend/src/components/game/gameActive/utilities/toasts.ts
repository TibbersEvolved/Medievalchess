import { toast, Zoom } from "react-toastify";

export function serverMessage(s: string, type: number) {
  if (type == 0) {
    toast.success(s);
  }
  if (type == 1) {
    toast.warn(s);
  }
}

export function endTurnToast(s: string) {
  toast.success(s, {
    position: "top-center",
    theme: "colored",
    autoClose: 2000,
    transition: Zoom,
  });
}

export function serverPromise(
  serverPromise: Promise<unknown> | (() => Promise<unknown>),
  msg: string
) {
  toast.promise(serverPromise, {
    pending: "Creating Game...",
    error: "Server Error...",
    success: "Game was created!",
  });
}
