<template>
  <div>
    이달의 안주
    <p v-for="food in sortedFoodList" :key="food.id">{{ food.title }}</p>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useLikeStore } from "@/stores/boardLike";
import { useFoodStore } from "@/stores/food";

const likeStore = useLikeStore();
const foodStore = useFoodStore();
const foodList = ref([]);
const fetchFoodData = async () => {
  foodList.value = [];
  await foodStore.getFoodList();
  foodList.value = foodStore.foodList;

  // heart 값을 비동기로 설정
  const heartPromises = foodList.value.map(async (food) => {
    food.heart = await likeStore.likeCnt(1, food.id);
  });

  await Promise.all(heartPromises);

  // heart 값으로 정렬
  foodList.value.sort((a, b) => b.heart - a.heart);
  console.log(foodList.value);
};

onMounted(fetchFoodData);

const sortedFoodList = computed(() => {
  return foodList.value.slice(0, 1);
});
</script>

<style scoped></style>
