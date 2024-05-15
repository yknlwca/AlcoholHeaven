<template>
<div class="container">
    <h2>안주 목록</h2>
    <hr />
    <FoodSearch />
    <table class="table table-hover text-center">
      <tr>
        <th>번호</th>
        <th>메뉴</th>
        <th>작성자</th>
        <th>주종</th>
        <th>내용</th>
        <th>지역</th>
        <!-- 이미지는 디테일에서 -->
      </tr>
      <tr v-for="food in currentPageFoodList" :key="food.id">
        <td>{{ food.id }}</td>
        <td>{{ food.menu }}</td>
        <td>
          <RouterLink :to="`/food/${food.id}`">{{ food.content }}</RouterLink>
        </td>
        <td>{{ food.writer }}</td>
        <td>{{ food.region }}</td>
        <td>{{ food.kindOf }}</td>

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
import { useFoodStore } from '@/stores/food';
import { computed, ref, onMounted } from 'vue';
import FoodSearch from '@/components/food/FoodSearch.vue';

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

const currentPageFoodList = computed(() => {
    return store.foodList.slice(
        (currentPage.vlaue - 1) * perPage,
        currentPage.value * perPage
    );
});

</script>

<style scoped>

</style>