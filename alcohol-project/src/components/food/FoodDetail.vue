<template>
  <!-- <h4>안주 추천 상세</h4> -->
  <br />
  <div class="container d-flex">
    <hr />
    <div class="left d-flex flex-column p-2" style="width: 70%">
      <div class="d-flex justify-content-center">
        <img
          style="width: 70%; border-radius: 10%"
          :src="`http://localhost:8080/uploads/food/${store.food.img}`"
          alt=""
        />
      </div>
      <div class="container" style="width: 75%">
        <!-- 리뷰 띄우기 -->

        <Review :review-type="{ id: id, type: 2 }" />
      </div>
    </div>
    <div class="right d-flex flex-column p-2" style="width: 50%">
      <br />
      <br />
      <div>
        <h3>제목 : {{ store.food.title }}</h3>
        <div v-if="store.food.userId === loginUser.id">
          <button
            type="button"
            class="btn btn-outline-success"
            style="
              --bs-btn-padding-y: 0.25rem;
              --bs-btn-padding-x: 0.5rem;
              --bs-btn-font-size: 0.75rem;
            "
            @click="moveUpdate"
          >
            수정
          </button>
          <span>&nbsp;</span>
          <button
            type="button"
            class="btn btn-outline-success"
            style="
              --bs-btn-padding-y: 0.25rem;
              --bs-btn-padding-x: 0.5rem;
              --bs-btn-font-size: 0.75rem;
            "
            @click="foodDelete"
          >
            삭제
          </button>
        </div>
      </div>
      <hr />
      <div>
        <h5>메뉴 : {{ store.food.menu }}</h5>
        <h5>설명 : {{ store.food.content }}</h5>
        <h5>어울리는 술 : {{ store.food.kindOf }}</h5>
        <h5>지역 : {{ store.food.region }}</h5>
      </div>
      <hr />
      <!-- 지도 키워드 -->
      <!-- <h5>{{ store.food.region }} 주변 {{ store.food.menu }} 맛집</h5> -->
      <KakaoMap
        style="border-radius: 10%; width: 100%"
        :lat="37.566826"
        :lng="126.9786567"
        :level="7"
        @onLoadKakaoMap="onLoadKakaoMap"
      >
        <KakaoMapMarker
          v-for="(marker, index) in markerList"
          :key="marker.key === undefined ? index : marker.key"
          :lat="marker.lat"
          :lng="marker.lng"
          :infoWindow="marker.infoWindow"
          :clickable="true"
          @onClickKakaoMapMarker="onClickMapMarker(marker)"
        />
      </KakaoMap>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import { KakaoMap, KakaoMapMarker } from "vue3-kakao-maps";
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref, reactive } from "vue";
import { useFoodStore } from "@/stores/food";

const route = useRoute();
const router = useRouter();
const store = useFoodStore();
const id = ref(route.params.id);
onMounted(() => {
  store.getFood(id.value);
});
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const moveUpdate = function () {
  router.push({ name: "foodUpdate", params: { id: id.value } });
};
const foodDelete = function () {
  store.deleteFood(id.value);
};

// 지도
// npm install vue3-kakao-maps
const map = ref();
const markerList = ref([]);

const onLoadKakaoMap = (mapRef) => {
  map.value = mapRef;

  // 장소 검색 객체 생성
  const ps = new kakao.maps.services.Places();

  // 키워드 장소 검색
  const keyword = store.food.region + " " + store.food.menu + "맛집";
  // console.log(keyword);
  ps.keywordSearch(keyword, placesSearchCB);
};

// 키워드 검색 완료 시 호출되는 콜백 함수
const placesSearchCB = (data, status) => {
  if (status === kakao.maps.services.Status.OK) {
    // 검색된 장소 위치를 기준으로 지도 범위를 재설정
    // LatLngBounds 객체에 좌표 추가
    const bounds = new kakao.maps.LatLngBounds();

    for (let marker of data) {
      // console.log(marker);
      const markerItem = {
        lat: marker.y,
        lng: marker.x,
        infoWindow: {
          content:
            `<div  style="
              font-size: 10px;
            ">` +
            marker.place_name +
            `<br>` +
            `<p>` +
            marker.road_address_name +
            `</p>` +
            marker.phone +
            `</div>`,
          visible: false,
        },
      };
      markerList.value.push(markerItem);
      bounds.extend(new kakao.maps.LatLng(Number(marker.y), Number(marker.x)));
    }

    // 검색된 장소 위치 기준 지도 범위 재설정
    map.value?.setBounds(bounds);
  }
};

// 마커 클릭시 인포윈도우의 visible 값 반전
const onClickMapMarker = (markerItem) => {
  if (
    markerItem.infoWindow?.visible !== null &&
    markerItem.infoWindow?.visible !== undefined
  ) {
    markerItem.infoWindow.visible = !markerItem.infoWindow.visible;
  } else {
    markerItem.infoWindow.visible = true;
  }
};
</script>

<style scoped></style>
