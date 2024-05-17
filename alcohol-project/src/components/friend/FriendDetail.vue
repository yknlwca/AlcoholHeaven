<template>
  <br />
  <div class="container d-flex">
    <hr />
    <div class="left d-flex flex-column p-2" style="width: 50%">
      <div class="d-flex justify-content-center">
        <img style="width: 70%; border-radius: 10%"
          src="data:image/jpeg;base64,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"
          alt="" />
      </div>

    </div>
    <div class="right d-flex flex-column p-2" style="width: 50%">
      <div>
        <h2>{{ store.friend.title }}</h2>
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
        >
          삭제
        </button>
      </div>
      <hr />
      <div>
        <h5>저를 소개합니다.</h5>
        <h5>
          {{ store.friend.intro }}
        </h5>

        <h5>좋아하는 술 : {{ store.friend.kindOf }}</h5>
        <h5>사는 지역 : {{ store.friend.region }}</h5>
      </div>
      <hr />
      <div><!-- 리뷰 띄우기 -->
        <Review  :review-type="{ id: id, type: 3 }" />
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useFriendStore } from "@/stores/friend";
const route = useRoute();
const router = useRouter();
const store = useFriendStore();
const id = ref(route.params.id);
onMounted(() => {
  console.log(id.value)
  store.getFriend(id.value);
});

const moveUpdate = function () {
  router.push({ name: "friendUpdate" });
};

</script>

<style scoped>
</style>
