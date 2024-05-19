<template>
  <!-- <h4>안주 추천 상세</h4> -->
  <br />
  <div class="container d-flex">
    <hr />
    <div class="left d-flex flex-column p-2" style="width: 70%">
      <div class="d-flex justify-content-center">
        <img style="width: 70%; border-radius: 10%" :src="`http://localhost:8080/uploads/alcohol/${store.alcohol.img}`" alt="" />
      </div>
      <div class="container" style="width: 75%">

        <Review :review-type="{ id: store.alcohol.id, type: 1 }" />
      </div>
    </div>
    <div class="right d-flex flex-column p-2" style="width: 50%">
      <br />
      <br />
      <div>
        <h3>이름 : {{ store.alcohol.name }}</h3>
        <div v-if="store.alcohol.userId === loginUser.id">
          <button type="button" class="btn btn-outline-success" style="
              --bs-btn-padding-y: 0.25rem;
              --bs-btn-padding-x: 0.5rem;
              --bs-btn-font-size: 0.75rem;
            " @click="moveUpdate">
            수정
          </button>
          <span>&nbsp;</span>
          <button type="button" class="btn btn-outline-success" style="
              --bs-btn-padding-y: 0.25rem;
              --bs-btn-padding-x: 0.5rem;
              --bs-btn-font-size: 0.75rem;
            " @click="alcoholDelete">
            삭제
          </button>
        </div>
      </div>
      <hr />
      <div>
        <h5>작성자 : {{ store.alcohol.userId }}</h5>
        <h5>설명 : {{ store.alcohol.content }}</h5>
        <h5>도수 : {{ store.alcohol.weight }}</h5>
        <h5>종류 : {{ store.alcohol.kindOf }}</h5>
        <h5>지역 : {{ store.alcohol.region }}</h5>
        <h5>상세 지역 : {{ store.alcohol.detailRegion }}</h5>
      </div>
      <hr />
      <!-- 지도 키워드 -->
      <div>
        <button>{{ store.alcohol.name }}과 어울리는 안주 추천받기</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref, toRaw } from "vue";
import { useAlcoholStore } from "@/stores/alcohol";

const route = useRoute();
const router = useRouter();
const store = useAlcoholStore();
const id = ref(route.params.id);
onMounted(() => {
  store.alcoholDetail(id.value);
});
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const moveUpdate = function () {
  router.push({ name: "alcoholUpdate", params: { id: id.value } });
};
const alcoholDelete = function () {
  store.deleteAlcohol(id.value);
};

// 지도
</script>

<style scoped></style>
