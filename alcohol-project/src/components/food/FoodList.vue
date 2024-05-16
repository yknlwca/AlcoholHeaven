<template>
  <div class="container d-flex flex-column align-items-center">
    <hr />
    <div class="container d-flex justify-content-center">
      <FoodSearch style="width: 80%" />
    </div>
    <br />
    <table class="table table-hover text-center" style="width: 70%">
      <tr>
        <th
          style="
            width: 5%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          번호
        </th>
        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          작성자
        </th>
        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          제목
        </th>
        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          번호
        </th>

        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          지역
        </th>
        <th style="width: 15%; border-bottom: 1px solid black">좋아요</th>
        <!-- 이미지는 디테일에서 -->
      </tr>
      <tr v-for="food in currentPageFoodList" :key="food.id">
        <td style="width: 5%; border-right: 1px solid black">
          {{ food.id }}
        </td>
        <td style="width: 15%; border-right: 1px solid black">
          {{ food.userId }}
        </td>
        <td class="p-2" style="width: 15%; border-right: 1px solid black">
          <RouterLink :to="`/food/${food.id}`">
            {{ food.title }}
          </RouterLink>
        </td>
        <td style="width: 15%; border-right: 1px solid black">
          <!-- menu 지우고 kindOf 어울리는 술로 바꿔야 한다 백엔드까지 -->
          {{ food.menu }}
        </td>
        <td style="width: 15%; border-right: 1px solid black">
          {{ food.region }}
        </td>
        <td style="width: 15%">
          {{ food.heart }}
        </td>
      </tr>
    </table>
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
          :class="{ active: currentPage === page }"
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
import { computed, ref, onMounted } from "vue";
import FoodSearch from "@/components/food/FoodSearch.vue";

const store = useFoodStore();

onMounted(() => {
  store.getFoodList();
});

const perPage = 10;
const currentPage = ref(1);

const pageCount = computed(() => {
  return Math.ceil(store.foodList.length / perPage);
});

const clickPage = function (page) {
  currentPage.value = page;
};
console.log(store.foodList);
const currentPageFoodList = computed(() => {
  return store.foodList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
</script>

<style scoped></style>
