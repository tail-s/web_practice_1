<template>
  <tr>
    <td>{{ board_id }}</td>
    <td>
      <router-link :to="`/board/detail?id=${board_id}&target=${user_nick}`">{{
        board_title
      }}</router-link>
    </td>
    <td>{{ user_nick }}</td>
    <td>{{ board_viewcnt }}</td>
    <td>{{ board_like }}</td>
  </tr>
</template>

<script>
export default {
  name: "ListRow",
  props: {
    user_nick: String,
    board_id: Number,
    board_title: String,
    board_viewcnt: Number,
    board_like: Number,
    board: Object,
  },
};
</script>
<style scope>
td {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}
</style>
