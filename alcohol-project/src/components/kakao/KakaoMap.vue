<template>
  <div>
    <div class="map_wrap">
      <div
        id="map"
        ref="mapContainer"
        style="width: 100%; height: 100%; position: relative; overflow: hidden"
      ></div>
      <div id="menu_wrap" class="bg_white">
        <div class="option">
          <div>
            <form @submit.prevent="searchPlaces">
              키워드 :
              <input type="text" v-model="keyword" size="15" />
              <button type="submit">검색하기</button>
            </form>
          </div>
        </div>
        <hr />
        <ul id="placesList">
          <li
            v-for="(place, index) in places"
            :key="index"
            class="item"
            @mouseover="displayInfowindow(index)"
            @mouseout="closeInfowindow"
          >
            <span :class="'markerbg marker_' + (index + 1)"></span>
            <div class="info">
              <h5>{{ place.place_name }}</h5>
              <span v-if="place.road_address_name">{{
                place.road_address_name
              }}</span>
              <span v-if="place.road_address_name" class="jibun gray">{{
                place.address_name
              }}</span>
              <span v-else>{{ place.address_name }}</span>
              <span class="tel">{{ place.phone }}</span>
            </div>
          </li>
        </ul>
        <div id="pagination">
          <a
            v-for="page in paginationPages"
            :key="page"
            :class="{ on: page === currentPage }"
            @click="gotoPage(page)"
            >{{ page }}</a
          >
        </div>
      </div>
    </div>

    <!-- 끝 -->
  </div>
</template>

<script setup>
// 지도
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref, reactive } from "vue";
import { useFoodStore } from "@/stores/food";
const props = defineProps({
  food: Object,
});
const keyword = ref(props.food.region + " " + props.food.menu + " 맛집");

const places = reactive([]);
const markers = reactive([]);
const paginationPages = reactive([]);
const currentPage = ref(1);
const map = ref(null);
const ps = ref(null);
const infowindow = ref(null);
const loadKakaoMapScript = () => {
  return new Promise((resolve) => {
    if (typeof kakao !== "undefined") {
      resolve();
      return;
    }

    const script = document.createElement("script");
    script.onload = () => resolve();
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_API_KEY
    }`;
    document.head.appendChild(script);
  });
};

onMounted(async () => {
  await loadKakaoMapScript();

  let myCenter = new kakao.maps.LatLng(33.450701, 126.570667);

  const container = document.getElementById("map");
  const options = {
    center: myCenter,
    level: 3,
  };

  map.value = new kakao.maps.Map(container, options);
  ps.value = new kakao.maps.services.Places();
  infowindow.value = new kakao.maps.InfoWindow({ zIndex: 1 });

  searchPlaces();
});

const searchPlaces = () => {
  const keywordValue = keyword.value.trim();
  if (!keywordValue) {
    alert("키워드를 입력해주세요!");
    return;
  }
  ps.value.keywordSearch(keywordValue, placesSearchCB);
};

const placesSearchCB = (data, status, pagination) => {
  if (status === kakao.maps.services.Status.OK) {
    places.splice(0, places.length, ...data);
    displayPlaces(data);
    displayPagination(pagination);
  } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    alert("검색 결과가 존재하지 않습니다.");
  } else if (status === kakao.maps.services.Status.ERROR) {
    alert("검색 결과 중 오류가 발생했습니다.");
  }
};

const displayPlaces = (places) => {
  const bounds = new kakao.maps.LatLngBounds();
  removeMarkers();
  places.forEach((place, index) => {
    const placePosition = new kakao.maps.LatLng(place.y, place.x);
    const marker = addMarker(placePosition, index);
    bounds.extend(placePosition);
  });
  map.value.setBounds(bounds);
};

const addMarker = (position, idx) => {
  const imageSrc =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png";
  const imageSize = new kakao.maps.Size(36, 37);
  const imgOptions = {
    spriteSize: new kakao.maps.Size(36, 691),
    spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10),
    offset: new kakao.maps.Point(13, 37),
  };
  const markerImage = new kakao.maps.MarkerImage(
    imageSrc,
    imageSize,
    imgOptions
  );
  const marker = new kakao.maps.Marker({
    position,
    image: markerImage,
  });
  marker.setMap(map.value);
  markers.push(marker);
  return marker;
};

const removeMarkers = () => {
  markers.forEach((marker) => marker.setMap(null));
  markers.splice(0, markers.length);
};

const displayPagination = (pagination) => {
  paginationPages.splice(0, paginationPages.length);
  for (let i = 1; i <= pagination.last; i++) {
    paginationPages.push(i);
  }
};

const gotoPage = (page) => {
  currentPage.value = page;
  ps.value.gotoPage(page);
};

const displayInfowindow = (index) => {
  const marker = markers[index];
  const place = places[index];
  const content = `<div style="padding:5px;z-index:1;">${place.place_name}</div>`;
  infowindow.value.setContent(content);
  infowindow.value.open(map.value, marker);
};

const closeInfowindow = () => {
  infowindow.value.close();
};
</script>

<style scoped>
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}

.map_wrap a,
.map_wrap a:hover,
.map_wrap a:active {
  color: #000;
  text-decoration: none;
}

.map_wrap {
  position: relative;
  width: 100%;
  height: 500px;
}

#menu_wrap {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  width: 250px;
  margin: 10px 0 30px 10px;
  padding: 5px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}

.bg_white {
  background: #fff;
}

#menu_wrap hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 2px solid #5f5f5f;
  margin: 3px 0;
}

#menu_wrap .option {
  text-align: center;
}

#menu_wrap .option p {
  margin: 10px 0;
}

#menu_wrap .option button {
  margin-left: 5px;
}

#placesList li {
  list-style: none;
}

#placesList .item {
  position: relative;
  border-bottom: 1px solid #888;
  overflow: hidden;
  cursor: pointer;
  min-height: 65px;
}

#placesList .item span {
  display: block;
  margin-top: 4px;
}

#placesList .item h5,
#placesList .item .info {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}

#placesList .item .info {
  padding: 10px 0 10px 55px;
}

#placesList .info .gray {
  color: #8a8a8a;
}

#placesList .info .jibun {
  padding-left: 26px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
    no-repeat;
}

#placesList .info .tel {
  color: #009900;
}

#placesList .item .markerbg {
  float: left;
  position: absolute;
  width: 36px;
  height: 37px;
  margin: 10px 0 0 10px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
    no-repeat;
}

#placesList .item .marker_1 {
  background-position: 0 -10px;
}

#placesList .item .marker_2 {
  background-position: 0 -56px;
}

#placesList .item .marker_3 {
  background-position: 0 -102px;
}

#placesList .item .marker_4 {
  background-position: 0 -148px;
}

#placesList .item .marker_5 {
  background-position: 0 -194px;
}

#placesList .item .marker_6 {
  background-position: 0 -240px;
}

#placesList .item .marker_7 {
  background-position: 0 -286px;
}

#placesList .item .marker_8 {
  background-position: 0 -332px;
}

#placesList .item .marker_9 {
  background-position: 0 -378px;
}

#placesList .item .marker_10 {
  background-position: 0 -423px;
}

#placesList .item .marker_11 {
  background-position: 0 -470px;
}

#placesList .item .marker_12 {
  background-position: 0 -516px;
}

#placesList .item .marker_13 {
  background-position: 0 -562px;
}

#placesList .item .marker_14 {
  background-position: 0 -608px;
}

#placesList .item .marker_15 {
  background-position: 0 -654px;
}

#pagination {
  margin: 10px auto;
  text-align: center;
}

#pagination a {
  display: inline-block;
  margin-right: 10px;
}

#pagination .on {
  font-weight: bold;
  cursor: default;
  color: #777;
}
</style>
