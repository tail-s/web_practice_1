
<template>
    <div id="videolist">
      <div v-for="video in videos" :key="video.id.videoId" @click="setVideo(video)">
        <VideoItem :video="video" />
      </div>
    </div>
  </template>
  
  <script>
  import VideoItem from "./VideoItem";
  import { mapGetters, mapMutations } from "vuex";
  export default {
    name: "VideoList",
    components: {
      VideoItem
    },
    computed: {
      ...mapGetters(["videos"])
    },
    methods: {
      ...mapMutations(["setVideo"])
    }
  };
  </script>
  
  <style>
  #videolist{
    width: 100%;
    height: 800px;
    overflow: auto;
    text-align: center;
  }
  </style>