<template>
  <br />
  <div class="container d-flex">
    <hr />
    <div class="left d-flex flex-column p-2" style="width: 50%">
      <div class="d-flex justify-content-center">
        <img
          style="width: 100%; border-radius: 10%"
          :src="`http://localhost:8080/uploads/friend/${store.friend.img}`"
          alt=""
        />
      </div>
    </div>
    <div class="right d-flex flex-column p-2" style="width: 50%">
      <div>
        <h3 class="d-flex justify-content-between">
          제목 : {{ store.friend.title }}
          <LikeItem
            :id="0"
            :userId="loginUser.id"
            :type="3"
            :boardId="store.friend.id"
          />
        </h3>
        <div v-if="store.friend.userId === loginUser.id">
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
            @click="deleteFriend"
          >
            삭제
          </button>
        </div>
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
      <div>
        <!-- 리뷰 띄우기 -->
        <Review :review-type="{ id: id, type: 3 }" />
      </div>
    </div>
  </div>
</template>

<script setup>
import Review from "@/components/common/Review.vue";
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useFriendStore } from "@/stores/friend";
import LikeItem from "@/components/common/LikeItem.vue";
const route = useRoute();
const router = useRouter();
const store = useFriendStore();
const id = ref(route.params.id);
onMounted(() => {
  // console.log(id.value)
  store.getFriend(id.value);
});

const moveUpdate = function () {
  router.push({ name: "friendUpdate", params: { id: id.value } });
};
const deleteFriend = function () {
  store.deleteFriend(id.value);
};
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
</script>

<style scoped></style>
