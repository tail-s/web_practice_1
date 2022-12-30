<template>
  <div class="regist">
    <h1 class="underline">게시글 등록</h1>
    <div class="regist_form">
      <label for="board_title">글 제목</label>
      <input
        type="text"
        name="board_title"
        v-model="board_title"
        ref="title"
        autocomplete="off"
      />
      <label for="board_content">내용</label>
      <textarea
        type="text"
        name="board_content"
        v-model="board_content"
        ref="content"
        style="height: 200px; font-size: medium"
      /><br />
      <button v-if="type == 'create'" @click="registBoard">등록</button> 
      &nbsp;
      <button v-if="type == 'modify'" @click="modifyBoard">수정</button>
      <div v-if="type=='modify'">&nbsp;</div> 
      <button v-if="type == 'modify'" @click="deleteBoard">삭제</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "WriteForm",
  props: {
    type: { type: String },
  },
  data() {
    return {
      board_id: "",
      user_pid: localStorage.getItem("user_pid"),
      user_nick: localStorage.getItem("user_nick"),
      board_title: "",
      board_content: "",
    };
  },
  created() {
    if (this.type === "modify") {
      http.get(`/board/${this.$route.query.id}`).then(({ data }) => {
        (this.board_id = data.board_id),
          (this.board_title = data.board_title),
          (this.board_content = data.board_content),
          (this.user_pid = data.user_pid);
      });
    }
  },
  methods: {
    registBoard() {
      let board = {
        user_pid: this.user_pid,
        user_nick: this.user_nick,
        board_title: this.board_title,
        board_content: this.board_content,
      };
      http.post("/board", board).then(({ data }) => {
        let msg = "등록 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "등록이 완료되었습니다.";
        }
        alert(msg);
        this.moveList();
      });
    },
    moveList() {
      this.$router.push("/board");
    },
    modifyBoard() {
      let board = {
        user_pid: this.user_pid,
        board_id: this.board_id,
        board_title: this.board_title,
        board_content: this.board_content,
      };

      http.put(`/board`, board).then(({ data }) => {
        let msg = "등록 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "등록이 완료되었습니다.";
        }
        alert(msg);
        this.moveList();
      });
    },
    deleteBoard() {
      this.$store.dispatch("deleteBoard", this.board_id);

    },
  },
};
</script>

<style scoped>
.regist {
  padding: 10px;
}
.regist_form {
  text-align: left;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 80%;
  margin: auto;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}
</style>
