<template>
  <div>
    <div id="map"></div>
    <div class="button-group">

      <button @click="displayMarker(markerPositions1)">트리니티 클럽</button>
      <button @click="displayMarker(markerPositions2)">안양 컨트리 클럽</button>
      <button @click="displayMarker(markerPositions3)">
        우정힐스 컨트리 클럽
      </button>
      <button @click="displayMarker(markerPositions4)">
        해슬리나 인 브릿지
      </button>
      <button @click="displayMarker(markerPositions5)">
        잭니클라우스 골프 클럽
      </button>
      <button @click="displayMarker(markerPositions6)">클럽나인 브릿지</button>
      <button @click="displayMarker(markerPositions7)">
        웰링턴 컨트리 클럽
      </button>
      <button @click="displayMarker(markerPositions8)">베어크리크 춘천</button>
      <button @click="displayMarker(markerPositions9)">
        파인비치 골프 링크스
      </button>
      <button @click="displayMarker(markerPositions0)">
        사우스 케이프 오너스 클럽
      </button>

    </div>
  </div>
</template>

<script>
export default {
  name: "MapService",
  data() {
    return {
      markerPositions1: [[37.20593380875184, 127.57633393949494]],
      markerPositions2: [[37.33966443077963, 126.93797831861136]],
      markerPositions3: [[36.767283238153304, 127.22156694865474]],
      markerPositions4: [[37.25084935386129, 127.61764761128735]],
      markerPositions5: [[37.380860625729454, 126.62590008460633]],
      markerPositions6: [[33.34599816908534, 126.40296981960076]],
      markerPositions7: [[37.1688671308674, 127.42050491168919]],
      markerPositions8: [[37.7690809841046, 127.71934653067395]],
      markerPositions9: [[34.69686169025432, 126.262423970613]],
      markerPositions0: [[34.8364929512669, 128.0744466895372]],

      markers: [],
      infowindow: null,
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=915cffed372954b7b44804ed422b9cf0";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng( 36.355769800230405,  127.29828282685513),
        level: 4,
      };

      this.map = new kakao.maps.Map(container, options);
    },

    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
   
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 570px;
  height: 570px;
}

.button-group {
  margin-left: 10%;
  margin-top: 20px;
}

button {
  margin: 0 3px;
}
</style>