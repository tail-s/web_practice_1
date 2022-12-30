<template>
  <div>
    <header-nav></header-nav>
    <router-view />
    <div class="ground">
      <div class="hill"></div>
      <div class="hill"></div>
      <div class="hill"></div>
      <div class="hill"></div>
    </div>
  </div>
</template>

<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
export default {
  components: {
    HeaderNav,
  },
};
</script>

<style>
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
</style>
