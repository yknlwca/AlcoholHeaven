<template>
  <!-- <h4>안주 추천 상세</h4> -->
  <br />
  <div class="container d-flex">
    <hr />
    <div class="left d-flex flex-column p-2" style="width: 70%">
      <div class="d-flex justify-content-center">
        <img
          style="width: 70%; border-radius: 10%"
          src="data:image/jpeg;base64,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"
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
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref, toRaw } from "vue";
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
</script>

<style scoped></style>
