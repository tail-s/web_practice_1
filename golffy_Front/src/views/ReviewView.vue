<template>
  <div>
      <div class="container">
          <h1>Review</h1>
          <input type="text" id="search" name="keyword" v-model="query" ref="keyword"
              style="text-align: center; font-size: 14pt;" autocomplete="off" @keypress.enter="getReviewList" />
          <br />
          <br />
          <h2>. . .</h2>
          <br />
      </div>
      <div class="list">
          <ul>
              <li v-for="(review,idx) in ReviewsList" :key="idx">
                <div class="titlecontainer"> 
                  <div class="review-title" v-html="review.title"></div> 
                  <div class="review-name"> [̲̅B][̲̅L][̲̅O][̲̅G] {{ review.bloggername }}</div>
                </div>
                  <div class="news-info">
                      <div class="review-link">
                          <a :href="review.link" target="_blank">{{ review.link }}</a>
                      </div>
                      <p class="review-desc">
                          <span v-html="review.description"></span>
                          <span>작성시간: {{ review.postdate }} </span>
                      </p>
                      <br />
                  </div>
              </li>
          </ul>
      </div>
  </div>
</template>

<script>
  import axios from "axios";

  export default {
      data() {
          return {
              query: "",
              ReviewsList: [],
          };
      },

      methods: {
          getReviewList() {
              const URL = "/v1/search/blog.json?&query=" + this.query + "&display=30";
              const clientId = "8N1I2orom4XSQ4hZoLnF";
              const clientSecret = "qCe6Lbanam";
              axios
                  .get(URL, {
                      headers: {
                          Accept: "application/json",
                          "X-Naver-Client-Id": clientId,
                          "X-Naver-Client-Secret": clientSecret,
                      },
                  })
                  .then((response) => {
                      this.ReviewsList = this.ReviewsList.concat(response.data.items);
                  });
              this.ReviewsList = [];
          },
      },
  };
</script>

<style scoped>
  * {
      padding: 0;
      margin: auto;
  }

  .container {
      margin-left: 5%;
      margin-top: 7%;
  }

  .list {
      width: 100%;
      height: 800px;
      overflow: auto;
      margin-left: 370px;
  }

  .review-title {
      margin-bottom: 4px;
      font-size: 18pt;
      color: #000000;
  }

  .review-info {
      font-size: 14px;
      color: #777;
  }

  .review-info span {
      padding-right: 8px;
  }

  .review-desc {
      margin-left: -1px;
      width: 800px;
  }

  #search {
      width: 300px;
      height: 30px;
      background: #46a362;
      border: none;
      outline: none;
      margin-bottom: 10px;
      margin-top: 10px;
      border-radius: 10px;
      cursor: pointer;
      margin: 0 auto;
      top: 100px;
      transition: all 0.3s;
      margin-top: 10px;
      margin-bottom: 10px;
  }

  #search input {
      height: 100%;
      border: none;
      background: rgba(0, 0, 0, 0);
      border-radius: 10px;
      width: 100%;
      color: #fff;
      padding-left: 20px;
      box-sizing: border-box;
      line-height: 2;
      font-size: 30px;
      font-weight: 100;
      margin-top: 10px;
      margin-bottom: 10px;
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