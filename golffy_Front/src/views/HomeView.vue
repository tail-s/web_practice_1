<template>
  <div class="home">
    <!-- <img
      alt="Vue logo"
      src="../assets/golffy_logo.png"
      id="logo"
      style="width: 30, height: 40; left=50%"
    /> -->
    <div id="title"> 
      GOLFFY
    </div>
    <div id="description">For golfer. news&community everyday</div>
    <div class="ground">
      <div class="hill"></div>
      <div class="hill"></div>
      <div class="hill"></div>
      <div class="hill"></div>
    </div>
    <div id="animation">
      <div class="green"></div>
      <div class="hole"></div>
      <div class="pole"></div>
      <div class="flag"></div>
      <div class="shot">
        <div class="ball">
          <div></div>
        </div>
        <div class="shadow"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  components: {},
};
</script>

<style>
* {
  padding: 0;
  margin: auto;
}

html,
body {
  width: 100%;
  height: 100%;
  overflow: hidden;
  position: fixed;
  top: 0%;
  left: 0%;
}

html {
  background-color: rgba(237, 248, 252, 1);
}

#logo {
  width: 160px;
  height: 100px;
}
#title{
  position: fixed;
  width: 100%;
  margin-top: 7%;
  text-align: center;
  z-index: 100;
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-size: 100px;
  color: rgba(18, 22, 26, 0.7);
}
#description {
  position: fixed;
  bottom: 10px;
  width: 100%;
  z-index: 100;
  font-family: Helvetica;
  font-weight: 200;
  color: rgba(18, 22, 26, 0.7);
  text-align: center;
  font-size: 11px;
  letter-spacing: 1px;
}

#animation {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 10%;
  left: 0%;
}

.ground {
  width: 100%;
  height: 50%;
  position: absolute;
  bottom: 0;
  left: 0;
  background-color: rgba(220, 240, 220, 1);
  opacity: 0.6;
  z-index: -1;
}

.ground .hill {
  width: 1000px;
  height: 1000px;
  border-radius: 1000px;
  position: absolute;
  -webkit-transform: translate(-500px, 0px);
  -moz-transform: translate(-500px, 0px);
  -ms-transform: translate(-500px, 0px);
  -o-transform: translate(-500px, 0px);
  transform: translate(-500px, 0px);
  background-color: inherit;
}

.ground .hill:nth-of-type(1) {
  left: 60%;
  top: -30px;
}

.ground .hill:nth-of-type(2) {
  left: 40%;
  top: -50px;
}

.ground .hill:nth-of-type(3) {
  left: 85%;
  top: -75px;
}

.ground .hill:nth-of-type(4) {
  left: 10%;
  top: -25px;
}

.green {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 700px;
  height: 500px;
  background-color: rgba(239, 248, 241, 1);
  border-radius: 500px;
  -webkit-transform: scale(1, 0.25);
  -moz-transform: scale(1, 0.25);
  -ms-transform: scale(1, 0.25);
  -o-transform: scale(1, 0.25);
  transform: scale(1, 0.25);
  margin-left: -200px;
  margin-top: -130px;
  opacity: 0.6;
}

.hole {
  -webkit-transform: scale(1, 0.25);
  -moz-transform: scale(1, 0.25);
  -ms-transform: scale(1, 0.25);
  -o-transform: scale(1, 0.25);
  transform: scale(1, 0.25);
  width: 20px;
  height: 20px;
  border-radius: 10px;
  background-color: rgba(145, 175, 150, 1);
  position: absolute;
  top: 50%;
  left: 50%;
  margin-left: 150px;
  margin-top: 110px;
}

.pole {
  width: 5px;
  height: 837px;
  background-color: #fff;
  position: absolute;
  top: 50%;
  left: 50%;
  border-radius: 100px;
  margin-top: -400px;
  margin-left: 158px;
  -webkit-transform: scale(1, 0.25);
  -moz-transform: scale(1, 0.25);
  -ms-transform: scale(1, 0.25);
  -o-transform: scale(1, 0.25);
  transform: scale(1, 0.25);
  z-index: 8;
}

.flag {
  border-right: 28px solid rgba(255, 114, 93, 1);
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  position: absolute;
  top: 50%;
  left: 50%;
  margin-left: 130px;
  margin-top: -81px;
  z-index: 2;
  -webkit-transform-origin: right center;
  transform-origin: right center;

  animation: flag 2s cubic-bezier(0.37, 0, 0.7, 0.99) 0s infinite alternate none;
  -webkit-animation: flag 2s cubic-bezier(0.37, 0, 0.7, 0.99) 0s infinite
    alternate none;
}

.ball,
.ball div {
  position: absolute;
  width: 9px;
  height: 9px;
  overflow: hidden;
  border-radius: 13px;
  z-index: 3;
}

.ball {
  top: 0%;
  left: 0%;
  animation: ballPos 6s linear 0s infinite normal none;
  -webkit-animation: ballPos 6s linear 0s infinite normal none;
}

.ball div {
  background-color: #fff;
  box-shadow: inset 0px -2px 2px rgba(195, 195, 195, 0.7);
  animation: ballDrop 6s ease-in 0s infinite normal none;
  -webkit-animation: ballDrop 6s ease-in 0s infinite normal none;
}

.shot {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0%;
  left: 0;
  margin-top: 2px;
  margin-left: 2px;
}

.shadow {
  z-index: 1;
  -webkit-transform: scale(1, 0.25) translate(0px, 16px);
  -moz-transform: scale(1, 0.25) translate(0px, 16px);
  -ms-transform: scale(1, 0.25) translate(0px, 16px);
  -o-transform: scale(1, 0.25) translate(0px, 16px);
  transform: scale(1, 0.25) translate(0px, 16px);
  width: 10px;
  height: 10px;
  border-radius: 10px;
  background-color: rgba(145, 175, 150, 1);
  position: absolute;
  animation: ballShadow 6s linear 0s infinite normal none;
  -webkit-animation: ballShadow 6s linear 0s infinite normal none;
}

@keyframes flag {
  22% {
    -webkit-transform: skew(0deg, 4deg);
    -moz-transform: skew(0deg, 4deg);
    -ms-transform: skew(0deg, 4deg);
    -o-transform: skew(0deg, 4deg);
    transform: skew(0deg, 4deg);
  }
  100% {
    -webkit-transform: skew(0deg, -4deg);
    -moz-transform: skew(0deg, -4deg);
    -ms-transform: skew(0deg, -4deg);
    -o-transform: skew(0deg, -4deg);
    transform: skew(0deg, -4deg);
  }
  79% {
    -webkit-transform: skew(0deg, 10deg);
    -moz-transform: skew(0deg, 10deg);
    -ms-transform: skew(0deg, 10deg);
    -o-transform: skew(0deg, 10deg);
    transform: skew(0deg, 10deg);
  }
  51% {
    -webkit-transform: skew(0deg, -12deg);
    -moz-transform: skew(0deg, -12deg);
    -ms-transform: skew(0deg, -12deg);
    -o-transform: skew(0deg, -12deg);
    transform: skew(0deg, -12deg);
  }
  0% {
    -webkit-transform: skew(0deg, 11deg);
    -moz-transform: skew(0deg, 11deg);
    -ms-transform: skew(0deg, 11deg);
    -o-transform: skew(0deg, 11deg);
    transform: skew(0deg, 11deg);
  }
}

@-webkit-keyframes flag {
  22% {
    -webkit-transform: skew(0deg, 4deg);
    -moz-transform: skew(0deg, 4deg);
    -ms-transform: skew(0deg, 4deg);
    -o-transform: skew(0deg, 4deg);
    transform: skew(0deg, 4deg);
  }
  100% {
    -webkit-transform: skew(0deg, -4deg);
    -moz-transform: skew(0deg, -4deg);
    -ms-transform: skew(0deg, -4deg);
    -o-transform: skew(0deg, -4deg);
    transform: skew(0deg, -4deg);
  }
  79% {
    -webkit-transform: skew(0deg, 10deg);
    -moz-transform: skew(0deg, 10deg);
    -ms-transform: skew(0deg, 10deg);
    -o-transform: skew(0deg, 10deg);
    transform: skew(0deg, 10deg);
  }
  51% {
    -webkit-transform: skew(0deg, -12deg);
    -moz-transform: skew(0deg, -12deg);
    -ms-transform: skew(0deg, -12deg);
    -o-transform: skew(0deg, -12deg);
    transform: skew(0deg, -12deg);
  }
  0% {
    -webkit-transform: skew(0deg, 11deg);
    -moz-transform: skew(0deg, 11deg);
    -ms-transform: skew(0deg, 11deg);
    -o-transform: skew(0deg, 11deg);
    transform: skew(0deg, 11deg);
  }
}

@keyframes ballPos {
  46% {
    left: 50%;
    margin-left: 148px;
    margin-top: 110px;
    top: 50%;
  }
  47% {
  }
  47% {
  }
  43% {
    left: 50%;
    margin-left: 138px;
    margin-top: 110px;
    top: 50%;
  }
  45% {
    left: 50%;
    margin-left: 146px;
    margin-top: 110px;
    top: 50%;
  }
  30% {
    left: 50%;
    margin-left: 60px;
    margin-top: 110px;
    top: 50%;
  }
  29% {
    left: 50%;
    margin-left: 52px;
    margin-top: 105px;
    top: 50%;
  }
  47% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
  }
  28% {
    left: 50%;
    margin-left: 45px;
    margin-top: 110px;
    top: 50%;
  }
  27% {
    left: 50%;
    margin-left: 30px;
    margin-top: 92px;
    top: 50%;
  }
  26% {
    left: 50%;
    margin-left: 20px;
    margin-top: 95px;
    top: 50%;
  }
  24% {
    left: 50%;
    margin-left: -15px;
    margin-top: 85px;
    top: 50%;
  }
  22% {
    left: 50%;
    margin-left: -44px;
    margin-top: 85px;
    top: 50%;
  }
  25% {
    left: 50%;
    margin-left: 5px;
    margin-top: 110px;
    top: 50%;
  }
  23% {
    left: 50%;
    margin-left: -30px;
    margin-top: 80px;
    top: 50%;
  }
  100% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
  }
  21% {
    left: 50%;
    margin-left: -60px;
    margin-top: 110px;
    top: 50%;
  }
  16% {
    left: 50%;
    margin-left: -130px;
    margin-top: 0px;
    top: -13px;
  }
  0% {
    top: -13px;
    margin-left: 0px;
    margin-top: 0px;
    left: -20px;
  }
}

@-webkit-keyframes ballPos {
  46% {
    left: 50%;
    margin-left: 148px;
    margin-top: 110px;
    top: 50%;
  }
  47% {
  }
  47% {
  }
  43% {
    left: 50%;
    margin-left: 138px;
    margin-top: 110px;
    top: 50%;
  }
  45% {
    left: 50%;
    margin-left: 146px;
    margin-top: 110px;
    top: 50%;
  }
  30% {
    left: 50%;
    margin-left: 60px;
    margin-top: 110px;
    top: 50%;
  }
  29% {
    left: 50%;
    margin-left: 52px;
    margin-top: 105px;
    top: 50%;
  }
  47% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
  }
  28% {
    left: 50%;
    margin-left: 45px;
    margin-top: 110px;
    top: 50%;
  }
  27% {
    left: 50%;
    margin-left: 30px;
    margin-top: 92px;
    top: 50%;
  }
  26% {
    left: 50%;
    margin-left: 20px;
    margin-top: 95px;
    top: 50%;
  }
  24% {
    left: 50%;
    margin-left: -15px;
    margin-top: 85px;
    top: 50%;
  }
  22% {
    left: 50%;
    margin-left: -44px;
    margin-top: 85px;
    top: 50%;
  }
  25% {
    left: 50%;
    margin-left: 5px;
    margin-top: 110px;
    top: 50%;
  }
  23% {
    left: 50%;
    margin-left: -30px;
    margin-top: 80px;
    top: 50%;
  }
  100% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
  }
  21% {
    left: 50%;
    margin-left: -60px;
    margin-top: 110px;
    top: 50%;
  }
  16% {
    left: 50%;
    margin-left: -130px;
    margin-top: 0px;
    top: -13px;
  }
  0% {
    top: -13px;
    margin-left: 0px;
    margin-top: 0px;
    left: -20px;
  }
}

@keyframes ballShadow {
  46% {
    left: 50%;
    margin-left: 148px;
    margin-top: 110px;
    top: 50%;
    opacity: 1;
  }
  47% {
  }
  47% {
  }
  43% {
    left: 50%;
    margin-left: 138px;
    margin-top: 110px;
    top: 50%;
  }
  45% {
    left: 50%;
    margin-left: 146px;
    margin-top: 110px;
    top: 50%;
  }
  30% {
    left: 50%;
    margin-left: 60px;
    top: 50%;
    margin-top: 110px;
  }
  29% {
    left: 50%;
    margin-left: 52px;
    top: 50%;
    margin-top: 110px;
  }
  47% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
    opacity: 0;
  }
  28% {
    left: 50%;
    margin-left: 45px;
    top: 50%;
    margin-top: 110px;
  }
  27% {
    left: 50%;
    margin-left: 30px;
    top: 50%;
    margin-top: 110px;
  }
  26% {
    left: 50%;
    margin-left: 20px;
    top: 50%;
    margin-top: 110px;
  }
  24% {
    left: 50%;
    margin-left: -15px;
    top: 50%;
    margin-top: 110px;
  }
  22% {
    left: 50%;
    margin-left: -44px;
    top: 50%;
    margin-top: 110px;
  }
  25% {
    left: 50%;
    margin-left: 5px;
    top: 50%;
    margin-top: 110px;
  }
  23% {
    left: 50%;
    margin-left: -30px;
    top: 50%;
    margin-top: 110px;
  }
  100% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
    opacity: 0;
  }
  21% {
    left: 50%;
    margin-left: -60px;
    top: 50%;
    margin-top: 110px;
    opacity: 1;
  }
  16% {
    left: 50%;
    margin-left: -130px;
    top: 50%;
    margin-top: 110px;
    opacity: 1;
  }
  0% {
    top: 50%;
    margin-top: 110px;
    margin-left: 0px;
    left: -20px;
    opacity: 1;
  }
}

@-webkit-keyframes ballShadow {
  46% {
    left: 50%;
    margin-left: 148px;
    margin-top: 110px;
    top: 50%;
    opacity: 1;
  }
  47% {
  }
  47% {
  }
  43% {
    left: 50%;
    margin-left: 138px;
    margin-top: 110px;
    top: 50%;
  }
  45% {
    left: 50%;
    margin-left: 146px;
    margin-top: 110px;
    top: 50%;
  }
  30% {
    left: 50%;
    margin-left: 60px;
    top: 50%;
    margin-top: 110px;
  }
  29% {
    left: 50%;
    margin-left: 52px;
    top: 50%;
    margin-top: 110px;
  }
  47% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
    opacity: 0;
  }
  28% {
    left: 50%;
    margin-left: 45px;
    top: 50%;
    margin-top: 110px;
  }
  27% {
    left: 50%;
    margin-left: 30px;
    top: 50%;
    margin-top: 110px;
  }
  26% {
    left: 50%;
    margin-left: 20px;
    top: 50%;
    margin-top: 110px;
  }
  24% {
    left: 50%;
    margin-left: -15px;
    top: 50%;
    margin-top: 110px;
  }
  22% {
    left: 50%;
    margin-left: -44px;
    top: 50%;
    margin-top: 110px;
  }
  25% {
    left: 50%;
    margin-left: 5px;
    top: 50%;
    margin-top: 110px;
  }
  23% {
    left: 50%;
    margin-left: -30px;
    top: 50%;
    margin-top: 110px;
  }
  100% {
    left: 50%;
    margin-left: 152px;
    margin-top: 110px;
    top: 50%;
    opacity: 0;
  }
  21% {
    left: 50%;
    margin-left: -60px;
    top: 50%;
    margin-top: 110px;
    opacity: 1;
  }
  16% {
    left: 50%;
    margin-left: -130px;
    top: 50%;
    margin-top: 110px;
    opacity: 1;
  }
  0% {
    top: 50%;
    margin-top: 110px;
    margin-left: 0px;
    left: -20px;
    opacity: 1;
  }
}

@keyframes ballDrop {
  46% {
    margin-top: 0px;
  }
  47% {
    margin-top: 9px;
  }
  100% {
    margin-top: 9px;
  }
  0% {
    margin-top: 0px;
  }
}

@-webkit-keyframes ballDrop {
  46% {
    margin-top: 0px;
  }
  47% {
    margin-top: 9px;
  }
  100% {
    margin-top: 9px;
  }
  0% {
    margin-top: 0px;
  }
}
</style>
