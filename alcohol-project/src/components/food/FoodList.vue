<template>
  <div class="container d-flex flex-column align-items-center">
    <hr />
    <div class="container d-flex justify-content-center">
      <FoodSearch style="width: 70%" />
    </div>
    <br />
    <table class="table" style="width: 70%">
      <thead>
        <tr>
          <th scope="col">번호</th>
          <th scope="col">작성자</th>
          <th scope="col">제목</th>
          <th scope="col">어울리는 술</th>

          <th scope="col">지역</th>
          <th scope="col">좋아요</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(food,index) in currentPageFoodList" :key="food.id">
          <td scope="row">
            {{ index+1 }}
          </td>
          <td>
            {{ food.userId }}
          </td>
          <td>
            <RouterLink :to="`/food/${food.id}`">
              <b>{{ food.title }}</b>
            </RouterLink>
          </td>
          <td>
            <!-- menu 지우고 kindOf 어울리는 술로 바꿔야 한다 백엔드까지 -->
            {{ food.kindOf }}
          </td>
          <td>
            {{ food.region }}
          </td>
          <td>
            {{ food.heart }}
          </td>
        </tr>
      </tbody>
    </table>
    <div style="width: 70%;">
    <button class="btn btn-outline-success" @click="createFood">안주 추천하기</button>
  </div>
    <nav aria-label="Page navigation">
      <ul class="pagination d-flex justify-content-center">
        <li class="page-item">
          <a
            class="page-link"
            @click.prevent="currentPage--"
            :class="{ disabled: currentPage <= 1 }"
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
            @click.prevent="currentPage++"
            :class="{ disabled: currentPage >= pageCount }"
            href="#"
            >&gt;</a
          >
        </li>
      </ul>
    </nav>
  </div>
</template>

<script setup>
import { useFoodStore } from "@/stores/food";
import { computed, ref, onMounted,onUnmounted, watch } from "vue";
import {useRouter, useRoute} from 'vue-router'
import FoodSearch from "@/components/food/FoodSearch.vue";

const store = useFoodStore();
const router = useRouter();
const route = useRoute();
const currentPage = ref(localStorage.getItem("page"));
onMounted(() => {
  currentPage.value = localStorage.getItem("page");
  if(!route.query.key){
    store.getFoodList();
  }else{
    store.searchFoodList({ key: route.query.key, word: route.query.word });

  }
});
onUnmounted(() => {
  // localStorage.setItem("alcohol", null);
  localStorage.setItem("page",1)
});
const perPage = 10;


const pageCount = computed(() => {
  return Math.ceil(store.foodList.length / perPage);
});

const clickPage = function (page) {
  localStorage.setItem("page", page);
  currentPage.value = page;
};
// console.log(store.foodList);
const currentPageFoodList = computed(() => {
  return store.foodList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
const createFood = function(){
  router.push({name: 'foodCreate'})
}
watch(
  () =>
    store.foodList.slice(
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
    // console.log("바뀜");
    if (!route.query.key) {
      store.getFoodList();
    } else {
      store.searchFoodList(
        { key: route.query.key, word: route.query.word }
      );
    }
  }
);
</script>

<style scoped>
a {
  color: rgb(3, 130, 84);
  text-decoration: none;
}
</style>
