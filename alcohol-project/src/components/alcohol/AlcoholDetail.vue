<template>
  <!-- <h4>안주 추천 상세</h4> -->
  <br />
  <div class="container d-flex">
    <hr />
    <div class="left d-flex flex-column p-2" style="width: 70%">
      <div class="d-flex justify-content-center">
        <img
          style="width: 70%; height: 100%; border-radius: 10%"
          :src="`http://localhost:8080/uploads/alcohol/${store.alcohol.img}`"
          alt=""
        />
      </div>
      <div class="container" style="width: 75%">
        <Review :review-type="{ id: id, type: 1 }" />
      </div>
    </div>
    <div class="right d-flex flex-column p-2" style="width: 50%">
      <br />
      <div>
        <h3>이름 : {{ store.alcohol.name }}</h3>
        <div v-if="store.alcohol.userId === loginUser.id">
          <button
            type="button"
            class="btn btn-outline-success"
            style="
              --bs-btn-padding-y: 0.25rem;
              --bs-btn-padding-x: 0.5rem;
              --bs-btn-font-size: 0.56em;
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
              --bs-btn-font-size: 0.6rem;
            "
            @click="alcoholDelete"
          >
            삭제
          </button>
        </div>
      </div>
      <hr />
      <div>
        <h5>설명</h5>
        <pre>{{ store.alcohol.content }}</pre>
        <hr />
        <h5>작성자 :</h5>
        <span>&nbsp;{{ store.alcohol.userId }}</span>
        <br />
        <h5>도수 :</h5>
        <span>&nbsp;</span>{{ store.alcohol.weight }}
        <br />
        <h5>종류 :</h5>
        <span>&nbsp;</span>{{ store.alcohol.kindOf }}
        <br />
        <h5>지역 :</h5>
        <span>&nbsp;</span>{{ store.alcohol.region }}
        <br />
        <h5>상세 지역 :</h5>
        <span>&nbsp;</span>{{ store.alcohol.detailRegion }}
        <br />
      </div>
      <hr />
      <div>
        <button
          class="btn btn-outline-success"
          @click="getGPT(store.alcohol.region, store.alcohol.name)"
        >
          <span v-if="!loading">
            {{ store.alcohol.name }}과 어울리는 안주 추천받기
          </span>
          <span v-if="loading">
            <span
              class="spinner-border spinner-border-sm"
              role="status"
              aria-hidden="true"
            ></span>
            잠시후 안주가 도착합니다! 잠시만 기다려주세요!
          </span>
        </button>
      </div>

      <div v-if="store.content && !loading">
        <br />
        <p v-for="line in store.content.split('\n')">{{ line }}</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import { useRoute, useRouter } from "vue-router";
import { onMounted, onUnmounted, ref } from "vue";
import { useAlcoholStore } from "@/stores/alcohol";

const route = useRoute();
const router = useRouter();
const store = useAlcoholStore();
const id = ref(route.params.id);

onUnmounted(() => {
  store.reset();
});

onMounted(() => {
  store.alcoholDetail(id.value);
});
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const moveUpdate = function () {
  router.push({ name: "alcoholUpdate", params: { id: id.value } });
};
const alcoholDelete = function () {
  store.deleteAlcohol(id.value, store.alcohol.region);
};

const loading = ref(false);
const getGPT = (region, name) => {
  loading.value = true;
  store.getGPT(region, name).finally(() => {
    loading.value = false;
  });
};
</script>

<style scoped>
.loading-animation {
  font-size: 16px;
  color: rgb(3, 130, 84);

  /* animation-duration   */
  animation-name: lotate;
  animation-duration: 10s;
  /* or */
  /* animation : lotate 3s; */
}
/* 시작 시점에선 0도, 50% 시점에선 180도, 완료 시점에선 360도 회전시키는 애니메이션입니다. */
@keyframes lotate {
  0% {
    transform: rotate(0deg);
  }

  50% {
    transform: rotate(180deg);
  }

  100% {
    transform: rotate(360deg);
  }
}

#loading {
  width: 100px;
  height: 100px;
  background: blue;
  margin: 7em;

  /* animation-duration   */
  animation-name: lotate;
  animation-duration: 10s;
  /* or */
  /* animation : lotate 3s; */
}
h5 {
  display: inline-block;
}
</style>
