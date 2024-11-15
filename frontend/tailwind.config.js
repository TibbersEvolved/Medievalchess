/** @type {import('tailwindcss').Config} */
import daisyui from "daisyui";

export default {
  content: ["./src/**/*.{html,tsx,ts}"],
  daisyui: {
    themes: [
      {
        mainTheme: {
          primary: "#f5f5f4",

          secondary: "#a3e635",

          accent: "#f43f5e",

          neutral: "#ff00ff",

          "base-100": "#ffedd5",

          info: "#4ade80",

          success: "#d9f99d",

          warning: "#fde047",

          error: "#b91c1c",
        },
      },
    ],
  },
  theme: {
    extend: {},
  },
  plugins: [daisyui],
};
