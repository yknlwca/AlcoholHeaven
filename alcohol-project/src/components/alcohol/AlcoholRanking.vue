<template>
  <div>
    이달의 술
    <p v-for="(alcohol, index) in sortedAlcoholList" :key="index">
      {{ alcohol.name }}
    </p>
  </div>
</template>

<script setup>
import { ref, onMounted, computed, watch } from "vue";
import { useLikeStore } from "@/stores/boardLike";
import { useAlcoholStore } from "@/stores/alcohol";

const likeStore = useLikeStore();
const alcoholStore = useAlcoholStore();
const alcoholList = ref([]);

const fetchAlcoholData = async () => {
  alcoholList.value = [];
  await alcoholStore.getAllAlcoholList();
  alcoholList.value = alcoholStore.alcoholList;

  // heart 값을 비동기로 설정
  const heartPromises = alcoholList.value.map(async (alcohol) => {
    alcohol.heart = await likeStore.likeCnt(1, alcohol.id);
  });

  await Promise.all(heartPromises);

  // heart 값으로 정렬
  alcoholList.value.sort((a, b) => b.heart - a.heart);

  //   console.log(alcoholList.value);
};

onMounted(fetchAlcoholData);

const sortedAlcoholList = computed(() => {
  return alcoholList.value.slice(0, 5);
});
</script>

<style scoped></style>
