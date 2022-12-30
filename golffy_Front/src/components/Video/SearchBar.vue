<template>
    <div class="container">
      <input id="search" @keypress.enter="getVideos" type="text" autocomplete="off" style="text-align: center;"/>
      <br/>
    </div>
  </template>
  
  <script>
  import { mapActions } from "vuex";
  export default {
    name: "SearchBar",
    methods: {
      ...mapActions(["getVideos"])
    }
  };
  </script>
  
  <style>
  .container{
    text-align: center;
  }
  #search {
  width: 300px;
  height: 30px;
  border: none;
  outline: none;
  background: #46a362;
  border-radius: 10px;
  cursor: pointer;
  margin-bottom: 10px;
  top: 100px;
  transition: all 0.3s;
}
#search input {
  height: 100%;
  border: none;
  background: rgba(0, 0, 0, 0.3);
  border-radius: 10px;
  width: 100%;
  color: #fff;
  padding-left: 20px;
  box-sizing: border-box;
  line-height: 2;
  font-size: 20px;
  font-weight: 100;
}
#search input:focus {
  outline: none;
  background: #167a43;
}
#search:hover {
  background: #8ddbbd;
}
#search.open {
  width: 500px;
}
  </style>