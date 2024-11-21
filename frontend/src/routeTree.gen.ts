/* eslint-disable */

// @ts-nocheck

// noinspection JSUnusedGlobalSymbols

// This file was automatically generated by TanStack Router.
// You should NOT make any changes in this file as it will be overwritten.
// Additionally, you should also exclude this file from your linter and/or formatter to prevent it from being checked or modified.

// Import Routes

import { Route as rootRoute } from './routes/__root'
import { Route as PlayinfoImport } from './routes/playinfo'
import { Route as NewGameImport } from './routes/newGame'
import { Route as GameImport } from './routes/game'
import { Route as IndexImport } from './routes/index'

// Create/Update Routes

const PlayinfoRoute = PlayinfoImport.update({
  id: '/playinfo',
  path: '/playinfo',
  getParentRoute: () => rootRoute,
} as any)

const NewGameRoute = NewGameImport.update({
  id: '/newGame',
  path: '/newGame',
  getParentRoute: () => rootRoute,
} as any)

const GameRoute = GameImport.update({
  id: '/game',
  path: '/game',
  getParentRoute: () => rootRoute,
} as any)

const IndexRoute = IndexImport.update({
  id: '/',
  path: '/',
  getParentRoute: () => rootRoute,
} as any)

// Populate the FileRoutesByPath interface

declare module '@tanstack/react-router' {
  interface FileRoutesByPath {
    '/': {
      id: '/'
      path: '/'
      fullPath: '/'
      preLoaderRoute: typeof IndexImport
      parentRoute: typeof rootRoute
    }
    '/game': {
      id: '/game'
      path: '/game'
      fullPath: '/game'
      preLoaderRoute: typeof GameImport
      parentRoute: typeof rootRoute
    }
    '/newGame': {
      id: '/newGame'
      path: '/newGame'
      fullPath: '/newGame'
      preLoaderRoute: typeof NewGameImport
      parentRoute: typeof rootRoute
    }
    '/playinfo': {
      id: '/playinfo'
      path: '/playinfo'
      fullPath: '/playinfo'
      preLoaderRoute: typeof PlayinfoImport
      parentRoute: typeof rootRoute
    }
  }
}

// Create and export the route tree

export interface FileRoutesByFullPath {
  '/': typeof IndexRoute
  '/game': typeof GameRoute
  '/newGame': typeof NewGameRoute
  '/playinfo': typeof PlayinfoRoute
}

export interface FileRoutesByTo {
  '/': typeof IndexRoute
  '/game': typeof GameRoute
  '/newGame': typeof NewGameRoute
  '/playinfo': typeof PlayinfoRoute
}

export interface FileRoutesById {
  __root__: typeof rootRoute
  '/': typeof IndexRoute
  '/game': typeof GameRoute
  '/newGame': typeof NewGameRoute
  '/playinfo': typeof PlayinfoRoute
}

export interface FileRouteTypes {
  fileRoutesByFullPath: FileRoutesByFullPath
  fullPaths: '/' | '/game' | '/newGame' | '/playinfo'
  fileRoutesByTo: FileRoutesByTo
  to: '/' | '/game' | '/newGame' | '/playinfo'
  id: '__root__' | '/' | '/game' | '/newGame' | '/playinfo'
  fileRoutesById: FileRoutesById
}

export interface RootRouteChildren {
  IndexRoute: typeof IndexRoute
  GameRoute: typeof GameRoute
  NewGameRoute: typeof NewGameRoute
  PlayinfoRoute: typeof PlayinfoRoute
}

const rootRouteChildren: RootRouteChildren = {
  IndexRoute: IndexRoute,
  GameRoute: GameRoute,
  NewGameRoute: NewGameRoute,
  PlayinfoRoute: PlayinfoRoute,
}

export const routeTree = rootRoute
  ._addFileChildren(rootRouteChildren)
  ._addFileTypes<FileRouteTypes>()

/* ROUTE_MANIFEST_START
{
  "routes": {
    "__root__": {
      "filePath": "__root.tsx",
      "children": [
        "/",
        "/game",
        "/newGame",
        "/playinfo"
      ]
    },
    "/": {
      "filePath": "index.tsx"
    },
    "/game": {
      "filePath": "game.tsx"
    },
    "/newGame": {
      "filePath": "newGame.tsx"
    },
    "/playinfo": {
      "filePath": "playinfo.tsx"
    }
  }
}
ROUTE_MANIFEST_END */
