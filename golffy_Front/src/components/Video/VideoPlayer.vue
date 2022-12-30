<template>
    <div v-if="video.id" class="embed-responsive embed-responsive-16by9">
      <p align="center">
      <iframe
        class="embed-responsive-item"
        frameborder="0"
        allowfullscreen="1"
        style="width: 500px; height: 300px;"
        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
        :src="`https://www.youtube.com/embed/${video.id.videoId}`"
      ></iframe>
      </p>
    </div>
  </template>
  
  <script>
  import { mapGetters } from "vuex";
  export default {
    name: "VideoPlayer",
    computed: {
      ...mapGetters(["video"])
    }
  };
  </script>
  
  <style>
  </style>