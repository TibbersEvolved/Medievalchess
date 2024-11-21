import { toast } from "react-toastify";

export function serverMessage(s: string, type: number) {
  if (type == 0) {
    toast.success(s);
  }
  if (type == 1) {
    toast.warn(s);
  }
}
