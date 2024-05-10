// router/index.js

import { createRouter, createWebHistory } from "vue-router";
import RegionDetail from "../views/RegionDetail.vue";

const routes = [
  {
    path: "/",
    redirect: "/map"
  },
  {
    path: "/map",
    name: "Map",
    component: () => import("../components/Map.vue")
  },
  {
    path: "/region/:region",
    name: "RegionDetail",
    component: RegionDetail,
    props: true
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
