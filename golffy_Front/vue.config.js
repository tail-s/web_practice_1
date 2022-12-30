module.exports = {
  devServer: {
    proxy: {
      "/v1": {
        target: "https://openapi.naver.com/",
        changeOrigin: true,
      },
    },
  },
};
