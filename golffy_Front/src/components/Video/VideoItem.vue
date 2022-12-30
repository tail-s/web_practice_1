<template>
    <div class="card">
      <img class="card-img-top" :src="video.snippet.thumbnails.high.url" />
      <div class="card-body">
        <h5 class="card-title">{{ video.snippet.title }}</h5>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "VideoItem",
    props: {
      video: Object
    }
  };
  </script>
  
  <style>
  </style>