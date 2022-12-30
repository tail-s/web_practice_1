<template>
  <div>
    <div class="map">  
    <h1>Maps</h1>
    <h2>. . .</h2>
    <h3 style="margin-bottom: 5px;">한국 10대 코스</h3>
    </div>
    <map-service></map-service>
  </div>
</template>

<script>
import MapService from "@/components/map/MapService.vue";

export default {
  name: "MapView",
  components: {
    MapService,
  },
};
</script>

<style>
.map{
 text-align: center;
 margin-top: 15px;
}
</style>
