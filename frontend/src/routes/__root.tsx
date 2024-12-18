import * as React from "react";
import { Link, Outlet, createRootRoute } from "@tanstack/react-router";
import { TanStackRouterDevtools } from "@tanstack/router-devtools";
import Navbar from "../components/root/navbar";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";
import SiteFooter from "../components/root/siteFooter";

export const Route = createRootRoute({
  component: RootComponent,
});

const queryClient = new QueryClient();

function RootComponent() {
  return (
    <>
      <div className="renderScreen">
        <QueryClientProvider client={queryClient}>
          <ToastContainer />
          <Navbar />
          <Outlet />
        </QueryClientProvider>
      </div>
      <SiteFooter />
    </>
  );
}
