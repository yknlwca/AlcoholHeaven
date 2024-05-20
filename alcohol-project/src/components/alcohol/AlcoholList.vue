<template>
  <div
    class="container d-flex flex-column align-items-center"
    style="padding-top: 15px"
  >
    <ALcoholSearch style="width: 37rem" />
    <br />
    <div class="row d-flex" style="width: 38rem">
      <div
        class="card mx-2 my-2 col-12 col-sm-6 col-md-3"
        v-for="alcohol in currentPageAlcoholList"
        :key="alcohol.name"
        style="width: 18rem; padding-top: 10px"
      >
        <img
          :src="`http://localhost:8080/uploads/alcohol/${alcohol.img}`"
          :alt="alcohol.name"
          class="card-img-top rounded mx-auto d-block"
          style="height: 150px; width: 150px"
        />
        <div class="card-body">
          <RouterLink
            :to="{
              name: 'alcohol-detail',
              params: { name: alcohol.region, id: alcohol.id },
            }"
          >
            <h5 class="card-title">{{ alcohol.name }}</h5>
          </RouterLink>
          <p class="card-text text-truncate">
            {{ alcohol.content }}
          </p>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">지역 : {{ alcohol.region }}</li>
            <li class="list-group-item">
              세부 지역 : {{ alcohol.detailRegion }}
            </li>
            <li class="list-group-item">종류 : {{ alcohol.kindOf }}</li>
            <li class="list-group-item">좋아요 : {{ storeLike.likeCnt(1,alcohol.id) }}</li>
            <i
              class="bi bi-heart"
              :class="{ red: storeLike.check({id:0,userId: loginUser.id, type:1, boardId:alcohol.id}) }"
              @click="clickHeart({id:0,userId: loginUser.id, type:1, boardId:alcohol.id})"
            ></i>
          </ul>
        </div>
      </div>
    </div>
    <div>
      <nav aria-label="Page navigation example sticky-top">
        <ul class="pagination d-flex justify-content-center">
          <li class="page-item">
            <a
              class="page-link"
              :class="{ disabled: currentPage <= 1 }"
              @click.prevent="currentPage--"
              href="#"
              >&lt;</a
            >
          </li>
          <li
            class="page-item"
            :class="{ active: currentPage == page }"
            v-for="page in pageCount"
            :key="page"
          >
            <a class="page-link" href="#" @click.prevent="clickPage(page)">{{
              page
            }}</a>
          </li>
          <li class="page-item">
            <a
              class="page-link"
              :class="{ disabled: currentPage >= pageCount }"
              @click.prevent="currentPage++"
              href="#"
              >&gt;</a
            >
          </li>
        </ul>
      </nav>
    </div>
  </div>
  <!-- <router-view></router-view> -->
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { onMounted, ref, watch, computed, onUnmounted } from "vue";
import { useAlcoholStore } from "@/stores/alcohol";
import ALcoholSearch from "./ALcoholSearch.vue";
import { useLikeStore } from "@/stores/boardLike";
const route = useRoute();
const name = ref(route.params.name);
const store = useAlcoholStore();
const currentPage = ref(localStorage.getItem("page"));
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const storeLike = useLikeStore();
onMounted(() => {
  name.value = route.params.name;
  currentPage.value = localStorage.getItem("page");
  if (!route.query.key) {
    store.getAlcoholList(name.value);
  } else {
    store.searchAlcoholList(
      { key: route.query.key, word: route.query.word },
      name.value
    );
  }
});
onUnmounted(() => {
  // localStorage.setItem("alcohol", null);
  localStorage.setItem("page",1)
});
const perPage = 4;

if (localStorage.getItem("page") == 1) {
  currentPage.value = 1;
}

const pageCount = computed(() => {
  return Math.ceil(store.alcoholList.length / perPage);
});
const clickPage = function (page) {
  localStorage.setItem("page", page);
  currentPage.value = page;
};
const currentPageAlcoholList = computed(() => {
  return store.alcoholList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
watch(
  () =>
    store.alcoholList.slice(
      (currentPage.value - 1) * perPage,
      currentPage.value * perPage
    ),
  () => {
    // console.log(route.query);
    currentPage.value = localStorage.getItem("page");
  }
);
watch(
  () => route.query.key,
  () => {
    console.log("바뀜");
    if (!route.query.key) {
      store.getAlcoholList(name.value);
    } else {
      store.searchAlcoholList(
        { key: route.query.key, word: route.query.word },
        name.value
      );
    }
  }
);
watch(
  () => route.params.name,
  (newName) => {
    console.log("param", "바뀜");
    name.value = newName;
    currentPage.value = 1;
    localStorage.setItem("page", 1);
    store.getAlcoholList(newName);
  }
);

const clickHeart = function (boardLike) {
  console.log(storeLike.check(boardLike))
  if (storeLike.check(boardLike)) {
    storeLike.removeLike(boardLike);
    console.log(storeLike.check(boardLike))
  } else {
    storeLike.clickLike(boardLike);
    console.log(storeLike.check(boardLike))
  }
};
</script>

<style scoped>
.red {
  color: red;
}
</style>
