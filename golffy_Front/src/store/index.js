import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999`;

export default new Vuex.Store({
  state: {
    boards: [],
    board: {},
    cmts: [],
    cmt: {},
    target: "",
    userInput: "",
    videos: [],
    video: {},
    user: {},
    bCnt: "",
    cCnt: "",
  },
  getters: {
    userInput(state) {
      return state.userInput;
    },
    videos(state) {
      return state.videos;
    },
    video(state) {
      return state.video;
    },
    getBoard(state) {
      return state.board;
    },
    getBcnt(state) {
      return state.bCnt;
    },
    getCcnt(state) {
      return state.cCnt;
    },
  },
  mutations: {
    GET_BOARDS(state, payload) {
      state.boards = payload;
    },
    GET_BOARD(state, payload) {
      state.board = payload;
    },
    // CREATE_BOARD(state, payload){
    //   state.boards.push(payload)
    // },
    UPDATE_BOARD(state, payload) {
      state.board = payload;
    },
    GET_CMTS(state, payload) {
      state.cmts = payload;
    },
    GET_CMT(state, payload) {
      state.cmt = payload;
    },
    SAVE_TARGET(state, payload) {
      state.target = payload;
    },
    setUserInput(state, data) {
      state.userInput = data;
    },
    setVideos(state, data) {
      state.videos = data;
    },
    setVideo(state, data) {
      state.video = data;
    },
    setUser(state, data) {
      state.user = data;
    },
    userbcnt(state, payload) {
      state.bCnt = payload;
      console.log(state.bCnt);
    },
    userccnt(state, payload) {
      state.cCnt = payload;
    },
  },
  actions: {
    getBoards({ commit }, payload) {
      console.log(payload);
      let params = null;
      if (payload) params = payload;

      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "GET",
        data: params,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          console.log(res.data);
          commit("GET_BOARDS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getBoard({ commit }, id) {
      const API_URL = `${REST_API}/board/${id}`;
      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          commit("GET_BOARD", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createBoard({ commit }, board) {
      const API_URL = `${REST_API}/board`;
      commit;
      axios({
        url: API_URL,
        method: "POST",
        params: board,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then(async () => {
          // commit('CREATE_BOARD', board)
          router.push("/board");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateBoard({ commit }, board) {
      const API_URL = `${REST_API}/board`;
      axios({
        url: API_URL,
        method: "PUT",
        params: board,
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      }).then(() => {
        commit("UPDATE_BOARD", board);
        router.push({ name: "BoardDetail", params: { id: board.id } });
      });
    },
    deleteBoard({ commit }, id) {
      const API_URL = `${REST_API}/board/${id}`;
      axios({
        url: API_URL,
        method: "PUT",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then(() => {
          commit;
          alert("삭제가 완료되었습니다.");
          router.push({ name: `board` });
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getCmts({ commit }, payload) {
      console.log("실행");
      const API_URL = `${REST_API}/cmt/${payload}`;
      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      })
        .then((res) => {
          console.log(res.data);
          commit("GET_CMTS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    saveTarget({ commit }, payload) {
      commit("SAVE_TARGET", payload);
    },
    getVideos(context, e) {
      context.commit("setUserInput", e.target.value);
      const baseURL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyBzJcZ5-L2-UN6UABBM0bc2aymI4zxLoU0";
      axios
        .get(baseURL, {
          params: {
            key: API_KEY,
            part: "snippet",
            type: "video",
            q: context.getters.userInput,
            maxResults: 10,
          },
        })
        .then((response) => {
          context.commit("setVideos", response.data.items);
        });
    },

    login({ commit }, user) {
      const API_URL = `${REST_API}/user/login`;
      axios({
        url: API_URL,
        method: "POST",
        data: user,
      })
        .then((res) => {
          if (res.data.message == "success") {
            const NEXT_URL = `${REST_API}/user/login/${user.user_id}`;
            sessionStorage.setItem("access-token", res.data["access-token"]);

            axios({
              url: NEXT_URL,
              method: "GET",
            }).then((res2) => {
              commit("setUser", res2.data);
              localStorage.setItem("user_id", res2.data.user_id);
              localStorage.setItem("user_nick", res2.data.user_nick);
              localStorage.setItem("user_pid", res2.data.user_pid);
            });
            router.push("/board");
          } else {
            alert("아이디나 비밀번호를 확인 해 주세요!");
            router.push({ name: "loginForm" });
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // cmtDet({ commit }, id) {
    //   const API_URL = `${REST_API}/cmt/${id}`;
    //   axios({
    //     url: API_URL,
    //     method: "PUT",
    //     headers: {
    //       "access-token": sessionStorage.getItem("access-token"),
    //     },
    //   })
    //     .then((res) => {
    //       let msg = "등록 처리시 문제가 발생했습니다.";
    //       if (data === "success") {
    //         msg = "삭제가 완료되었습니다.";
    //         commit;
    //       }
    //       alert(msg);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
    registUser({ commit }, user) {
      const API_URL = `${REST_API}/user`;
      axios({
        url: API_URL,
        method: "POST",
        data: user,
      }).then((res) => {
        if (res.data == "success") {
          // console.log(commit);
          commit;
          alert("회원가입이 완료되었습니다.");
          // location.href = "/user/login";
          router.push({ name: "user" });
        } else {
          alert(res.data);
          this.$router.push({ name: "UserRegist" });
        }
      });
    },

    getbcnt({ commit }, payload) {
      const blahblah = `${REST_API}/board/bcnt/${payload}`;
      axios({
        url: blahblah,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      }).then((res) => {
        commit("userbcnt", res.data);
      });
    },

    getccnt({ commit }, payload) {
      const blahblah = `${REST_API}/cmt/ccnt/${payload}`;
      axios({
        url: blahblah,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("access-token"),
        },
      }).then((res) => {
        commit("userccnt", res.data);
      });
    },
  },

  modules: {},
});