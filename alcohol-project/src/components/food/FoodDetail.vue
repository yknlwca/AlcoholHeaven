<template>
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
      <br /><br />
      <div>
        <h3 class="d-flex justify-content-between">
          제목 : {{ store.food.title }}
          <LikeItem
            :id="0"
            :userId="loginUser.id"
            :type="2"
            :boardId="store.food.id"
          />
        </h3>

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
      <div class="map_wrap">
        <div class="map_container">
          <KakaoMap
            style="border-radius: 10%; width: 100%; height: 100%"
            :lat="37.566826"
            :lng="126.9786567"
            :level="7"
            @onLoadKakaoMap="onLoadKakaoMap"
          >
            <KakaoMapMarker
              v-for="(marker, index) in markerList"
              :key="index"
              :lat="marker.lat"
              :lng="marker.lng"
              :clickable="true"
              @onClickKakaoMapMarker="onClickMapMarker(marker)"
            />
            <KakaoMapCustomOverlay
              v-for="(marker, index) in markerList"
              :key="'overlay-' + index"
              :lat="marker.lat"
              :lng="marker.lng"
              :yAnchor="1.4"
              :visible="marker.overlay.visible"
              :content="marker.overlay.content"
            />
          </KakaoMap>
        </div>
        <div id="menu_wrap" class="bg_white">
          <div class="option">
            <div>
              추천 :
              <input
                type="text"
                v-model="keyword"
                id="keyword"
                size="15"
                @keyup.enter="searchPlaces"
              />
            </div>
          </div>
          <hr />
          <ul id="placesList"></ul>
          <div id="pagination"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import LikeItem from "@/components/common/LikeItem.vue";

import { useRoute, useRouter } from "vue-router";
import { computed, onMounted, ref, watch } from "vue";
import { useFoodStore } from "@/stores/food";

const route = useRoute();
const router = useRouter();
const store = useFoodStore();
const id = ref(route.params.id);

onMounted(() => {
  store.getFood(id.value);
});

const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const moveUpdate = () => {
  router.push({ name: "foodUpdate", params: { id: id.value } });
};

const foodDelete = () => {
  store.deleteFood(id.value);
};

// 지도
import {
  KakaoMap,
  KakaoMapMarker,
  KakaoMapCustomOverlay,
} from "vue3-kakao-maps";
import { debounce } from "lodash";

const map = ref();
const markerList = ref([]);
const infowindow = ref();
let markers = [];
const keywordInput = ref("");
const keyword = computed(() => `${store.food.region} ${store.food.menu} 맛집`);

const debouncedSearchPlaces = debounce(() => {
  searchPlaces();
}, 50);

watch(keyword, () => {
  keywordInput.value = keyword.value;
  debouncedSearchPlaces();
});

const onLoadKakaoMap = (mapRef) => {
  map.value = mapRef;

  infowindow.value = new kakao.maps.InfoWindow({ zIndex: 1 });

  // 장소 검색 객체 생성
  const ps = new kakao.maps.services.Places();

  // 키워드 장소 검색
  ps.keywordSearch(keyword.value, placesSearchCB);
};

const searchPlaces = () => {
  if (!keyword.value.trim()) {
    alert("키워드를 입력해주세요!");
    return;
  }
  const ps = new kakao.maps.services.Places();
  ps.keywordSearch(keyword.value, placesSearchCB);
};

// 키워드 검색 완료 시 호출되는 콜백 함수
const placesSearchCB = (data, status, pagination) => {
  if (status === kakao.maps.services.Status.OK) {
    displayPlaces(data);
    displayPagination(pagination);
  } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    alert("검색 결과가 존재하지 않습니다.");
  } else if (status === kakao.maps.services.Status.ERROR) {
    alert("검색 결과 중 오류가 발생했습니다.");
  }
};

// 검색 결과 목록과 마커를 표시하는 함수
const displayPlaces = (places) => {
  const listEl = document.getElementById("placesList");
  const fragment = document.createDocumentFragment();
  const bounds = new kakao.maps.LatLngBounds();

  // 기존 검색 결과 제거
  removeAllChildNodes(listEl);
  removeMarker();

  for (let i = 0; i < places.length; i++) {
    const placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);
    const marker = addMarker(placePosition, i);
    const itemEl = getListItem(i, places[i]);

    bounds.extend(placePosition);

    // 마커와 검색 결과 항목에 mouseover 이벤트 추가
    (function (marker, title) {
      kakao.maps.event.addListener(marker, "mouseover", function () {
        displayInfowindow(marker, title);
      });

      kakao.maps.event.addListener(marker, "mouseout", function () {
        infowindow.value.close();
      });

      itemEl.onmouseover = function () {
        displayInfowindow(marker, title);
        map.value.panTo(marker.getPosition()); // 마커 위치로 지도 중심 이동
      };

      itemEl.onmouseout = function () {
        infowindow.value.close();
      };
    })(marker, places[i].place_name);

    fragment.appendChild(itemEl);
  }

  listEl.appendChild(fragment);
  map.value.setBounds(bounds);
};

// 검색 결과 항목을 생성하는 함수
const getListItem = (index, places) => {
  const el = document.createElement("li");
  let itemStr = `
    <div class="info">
      <h5>${places.place_name}</h5>`;

  if (places.road_address_name) {
    itemStr += `<p>${places.road_address_name}</p>
      <p class="jibun gray">${places.address_name}</p>`;
  } else {
    itemStr += `<p>${places.address_name}</p>`;
  }
  if (places.phone) {
    itemStr += `<p class="tel">번호 : ${places.phone}</p></div>`;
  }
  el.innerHTML = itemStr + `<hr>`;
  el.className = "item";

  return el;
};

// 마커를 생성하고 지도에 표시하는 함수
const addMarker = (position, idx) => {
  const imageSrc =
    "http://t1.daumcdn.net/localimg/localimages/07/2018/pc/img/marker_spot.png ";
  const imageSize = new kakao.maps.Size(24, 35); // 이미지 크기 조정

  const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
  const marker = new kakao.maps.Marker({
    position: position,
    image: markerImage,
  });

  marker.setMap(map.value);
  markers.push(marker);

  return marker;
};

// 지도 위에 표시되고 있는 마커를 모두 제거하는 함수
const removeMarker = () => {
  for (let i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }
  markers = [];
};

// 검색 결과 목록 하단에 페이지 번호를 표시하는 함수
const displayPagination = (pagination) => {
  const paginationEl = document.getElementById("pagination");
  const fragment = document.createDocumentFragment();
  const currentScroll = window.scrollY;

  while (paginationEl.hasChildNodes()) {
    paginationEl.removeChild(paginationEl.lastChild);
  }

  for (let i = 1; i <= pagination.last; i++) {
    const el = document.createElement("a");
    el.href = "#";
    el.innerHTML = i + " ";

    if (i === pagination.current) {
      el.className = "on";
    } else {
      el.onclick = (function (i) {
        return function () {
          pagination.gotoPage(i);
          setTimeout(() => {
            window.scrollTo(0, currentScroll);
          }, 100);
        };
      })(i);
    }

    fragment.appendChild(el);
  }
  paginationEl.appendChild(fragment);
};

// 인포윈도우에 장소명을 표시하는 함수
const displayInfowindow = (marker, title) => {
  const content = `<div style="padding:5px;z-index:1;">${title}</div>`;
  infowindow.value.setContent(content);
  infowindow.value.open(map.value, marker);
};

// 검색 결과 목록의 자식 노드를 제거하는 함수
const removeAllChildNodes = (el) => {
  while (el.hasChildNodes()) {
    el.removeChild(el.lastChild);
  }
};
</script>

<style scoped>
.map_container {
  flex: 1;
  height: 400px;
}

.bg_white {
  background-color: white;
  width: 30%;
  max-height: 400px;
  overflow-y: auto;
  z-index: 2;
}

.option {
  padding: 10px;
}

.item {
  list-style: none;
  padding: 10px;
  border-bottom: 1px solid #ddd;
  cursor: pointer;
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

.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 10px;
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
  border-radius: 10%;
  top: 0;
  left: 0;
  bottom: 0;
  width: 170px;
  padding: 5px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}
</style>
