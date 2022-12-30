<template>
  <tr v-if="order == 'list'">
    <td>{{ user_nick_p }} : </td>
    &nbsp;
    <td>{{ cmt_p }}</td>
    <!-- <button @click="mod">수정</button> 일단 보류 -->
    <button v-if="user_nick_p == this.user_nick" @click="del(cmt_id_p)">
      삭제
    </button>
  </tr>

  <div v-else-if="order == 'create'">
    <td>
      <label for="cmt">댓글</label>
      <textarea type="text" id="cmt" v-model="cmt" />
      <button @click="create">등록</button>
    </td>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "CmtRow",
  props: {
    cmt_p: String,
    cmt_id_p: Number,
    user_nick_p: String,
    order: String,
  },
  data() {
    return {
      cmt_id: "",
      cmt: "",
      board_id: this.$store.state.target,
      user_pid: localStorage.getItem("user_pid"),
      user_nick: localStorage.getItem("user_nick"),
      check: false,
    };
  },
  created() {
    if (this.type === "list") {
      http.get(`/board/${this.cmt}`).then(({ data }) => {
        (this.cmt_id = data.cmt_id),
          (this.board_id = data.board_id),
          (this.cmt = data.cmt),
          (this.user_pid = data.user_pid),
          (this.user_nick = data.user_nick);
      });
    }
  },
  methods: {
    del(id) {
      http.put(`/cmt/${id}`).then(({ data }) => {
        let msg = "등록 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "삭제가 완료되었습니다.";
        }
        alert(msg);
        this.$router.go(`/board/detail/?id=${this.board_id}`);
      });
    },
    create() {
      let cmt = {
        cmt: this.cmt,
        board_id: this.board_id,
        user_pid: this.user_pid,
        user_nick: this.user_nick,
      };

      http.post("/cmt", cmt).then(({ data }) => {
        let msg = "등록 처리시 문제가 발생했습니다.";
        if (data === "success") {
          msg = "등록이 완료되었습니다.";
        }
        alert(msg);
        this.$router.go(`/board/detail/?id=${this.board_id}`);
      });
    },
  },
};
</script>

<style scope>
#cmt{
  width: 300px; 
  height: 80px;   
  }
td {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}
</style>
