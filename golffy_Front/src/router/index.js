import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import BoardView from "../views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardCreate from "@/components/board/BoardCreate.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";
import NewsView from "../views/NewsView.vue";
import ContentsView from "../views/ContentsView.vue";
import VideoView from "../views/VideoView.vue";
import MapView from "../views/MapView.vue";
// import MapService from "@/components/map/MapService.vue";
import ReviewView from "../views/ReviewView.vue";
import UserView from "../views/UserView.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import LoginForm from "@/components/user/LoginForm.vue";
import UserDetail from "@/components/user/UserDetail.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/board",
    component: BoardView,
    children: [
      {
        path: "",
        name: "board",
        component: BoardList,
      },
      {
        path: "create",
        name: "boardCreate",
        component: BoardCreate,
      },
      {
        path: "detail",
        name: "boardDetail",
        component: BoardDetail,
      },
      {
        path: "update",
        name: "boardUpdate",
        component: BoardUpdate,
      },
    ],
  },
  {
    path: "/news",
    name: "news",
    component: NewsView,
  },
  {
    path: "/contents",
    name: "contents",
    component: ContentsView,
  },
  {
    path: "/video",
    name: "video",
    component: VideoView,
  },
  {
    path: "/map",
    name: "map",
    component: MapView,
  },
  {
    path: "/review",
    name: "review",
    component: ReviewView,
  },
  {
    path: "/user",
    name: "user",
    component: UserView,
    children: [
      // {
      //   path: "regist",
      //   name: "regist",
      //   component: UserRegist,
      // },
      {
        path: "login",
        name: "loginForm",
        component: LoginForm,
      },
      {
        path: "detail",
        name: "userDetail",
        component: UserDetail,
      },
    ],
  },
  {
    path: "/regist",
    name: "regist",
    component: UserRegist,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;