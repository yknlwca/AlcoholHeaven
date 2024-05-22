<template>
  <div>
    <table class="table">
      <thead class="table-success">
        <tr>
          <th scope="col" style="background-color: rgb(1, 173, 111);color:white ;"> <h5>실시간 인기 안주🍖</h5></th>
        </tr>
      </thead>
      <tbody v-for="(food, index) in sortedFoodList" :key="food.id">
        <tr>
        <td scope="row" >
          <p v-if="food.heart != 0" style="display: inline-block">
            {{ index + 1 }}위
          </p>
          &nbsp;
          <RouterLink :to="`/food/${food.id}`" v-if="food.heart != 0">
          <b>{{ food.title }}</b>
          </RouterLink>
          <span v-if="food.heart != 0">({{ food.region }})</span>
        </td>
      </tr>
      </tbody>
    </table>
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
  console.log("ranking fetch");
  foodList.value = [];
  await foodStore.getFoodList();
  foodList.value = foodStore.foodList;
  console.log("after fetch", foodStore.foodList);
  // heart 값을 비동기로 설정
  const heartPromises = foodList.value.map(async (food) => {
    food.heart = await likeStore.likeCnt(2, food.id);
  });

  await Promise.all(heartPromises);

  // heart 값으로 정렬
  foodList.value.sort((a, b) => b.heart - a.heart);
  console.log(foodList.value);
};

onMounted(fetchFoodData);

const sortedFoodList = computed(() => {
  console.log("ranking computed", foodList.value);
  return foodList.value.slice(0, 5);
});
</script>

<style scoped>
* {
  font-family: "Palatino Linotype", "Book Antiqua";
  font-weight: bold;
}
a {
  color: rgb(3, 130, 84);
  text-decoration: none;
}
</style>
