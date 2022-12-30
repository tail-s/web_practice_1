<template>
  <div>
      <a @click="movePage" class="btn" id="green">글쓰기</a>
    <div class="list" v-if="boards">
      <table>
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 20%" />
          <col style="width: 40%" />
          <col style="width: 20%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <list-row
            v-for="(board, index) in boards"
            :key="index"
            :board_id="board.board_id"
            :board_title="board.board_title"
            :user_nick="board.user_nick"
            :board_viewcnt="board.board_viewcnt"
            :board="board"
          />
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import ListRow from "@/components/board/include/ListRow.vue";

export default {
  name: "BoardList",
  components: {
    ListRow,
  },
  computed: {
    ...mapState(["boards"]),
  },
  created() {
    this.$store.dispatch("getBoards", "");
  },
  methods: {
    movePage() {
      this.$router.push({ name: "boardCreate" });
    },
  },
};
</script>

<style scoped>

.btn {
  margin-left: 80%;
  border-radius: 5px;
  padding: 15px 25px;
  font-size: 22px;
  color: #fff;
}
#green {
  background-color: #167a43;
  box-shadow: 0px 5px 0px 0px #32884c;
}

#green:hover {
  background-color: #60a58b;
}
.list{
  margin-left: 4%;
  margin-top: 5%;
  width: 100%;
  height: 500px;
  overflow: auto;
}
</style>
