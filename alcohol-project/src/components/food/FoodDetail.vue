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
      <div>
        <h5>{{ store.food.region }} 주변 {{ store.food.menu }} 맛집</h5>
        지도
        <kakaoMap :food="store.food" />
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import kakaoMap from "@/components/kakao/KakaoMap.vue";
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
</script>

<style scoped></style>
