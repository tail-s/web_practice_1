<template>
  <div id="app">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-12">
          <h1 class="text-center" style="margin-top: 7%; margin-bottom: 10px;" >Video</h1>
          <SearchBar />
          <h2>. . .</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-8">
          <VideoPlayer />
        </div>
        <div class="col-4">
          <VideoList />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SearchBar from "@/components/Video/SearchBar.vue";
import VideoPlayer from "@/components/Video/VideoPlayer.vue";
import VideoList from "@/components/Video/VideoList.vue"; 

export default {
  name: "App",
  components: {
    SearchBar,
    VideoPlayer,
    VideoList,
  }
};
</script>

<style>
#app{
  margin-left: 5%;
  margin-top: 7%;
}
</style>