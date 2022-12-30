<template>
  <div class="regist">
    <h1 class="underline">게시글 조회</h1>
    <div class="regist_form">
      <div class="title">
        <div class="view" style="width: 80%">제목: {{ board.board_title }}</div>
        <div class="view" style="width: 20%">작성자: {{ board.user_nick }}</div>
      </div>
      <label for="board_content">내용</label>
      <div class="view">{{ board.board_content }}</div>
      <div class="etc">
        <div class="view" style="width: 15%">
          조회수: {{ board.board_viewcnt }}
        </div>
       
        <router-link
          :to="`/board/update?id=${board.board_id}`"
          v-if="value == this.board.user_nick"
          style="width: 10%"
          class="view"
          >수정</router-link>
        <router-link to="/board/" style="width: 10%" class="view"
          >목록</router-link>
      </div>
      <cmt-row order="create"></cmt-row>
      <br/>

      <div class="cmt-list"> 
      <table>
        <thead>
          <tr>
            <th> </th>
            <th> </th>
          </tr>
        </thead>
        <tbody>
          <cmt-row
            order="list"
            v-for="(cmt, index) in cmts"
            :key="index"
            :cmt_id_p="cmt.cmt_id"
            :cmt_p="cmt.cmt"
            :user_nick_p="cmt.user_nick"
          />
        </tbody>
      </table>
      </div>
  </div>
  </div>
</template>

<script>
import { mapState, mapGetters } from "vuex";
import CmtRow from "@/components/board/include/cmt/CmtRow.vue";

export default {
  name: "ViewDetail",
  data() {
    return {
      cmt: "",
      value: localStorage.getItem("user_nick"),
      board: {},
    };
  },
  components: {
    CmtRow,
  },
  props: ["target"],
  computed: {
    ...mapState(["cmts"]),
    ...mapGetters(["getBoard"]),
  },

  created() {
    this.$store.dispatch("getCmts", this.$store.state.target);
  },
  watch: {
    // $route(from, to) {
    //   console.log(from, to);
    // },
    getBoard(board) {
      this.board = board;
      return board;
    },
  },
};
</script>

<style scoped>
.regist {
  padding: 10px;
}
.title{
  flex-direction: column;
}
.etc{
  text-align: left;
  flex-direction: row;
}
.regist_form {
  text-align: left;
  border-radius: 5px;
  background-color: #edfbe0;
  padding: 20px;
  height: 500px;
  margin-left: 10%;
  margin-right: 10%;
  overflow: auto;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 2px solid rgb(0, 85, 53);
  border-radius: 4px;
  box-sizing: border-box;
  color: #000000;
  font-size: medium;
}
.cmt-list > table {
  margin-left:0;
}
</style>
