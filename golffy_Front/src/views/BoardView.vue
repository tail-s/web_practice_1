<template>
  <div id="container">
    <h1>Board</h1>
    <h2>. . .</h2>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "BoardView",
};
</script>

<style scoped>
#container{
  text-align: center;
  margin-top: 7%;
}
</style>
