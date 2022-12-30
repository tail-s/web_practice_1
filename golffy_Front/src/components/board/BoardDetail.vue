<template>
  <div>
    <view-detail />
  </div>
</template>

<script>
import ViewDetail from "@/components/board/include/ViewDetail.vue";

export default {
  name: "BoardDetail",
  components: {
    ViewDetail,
  },
  porps: {
    target: Number,
  },
  created() {
    this.$store.dispatch(
      "getBoard",
      new URL(document.location).searchParams.get("id")
    );
    this.$store.dispatch("saveTarget", new URL(document.location).searchParams.get("id"));
    // console.log(this.$store.state.target);

  },
};
</script>

<style>
.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.detail-content {
  padding: 10px 30px;
}
</style>
