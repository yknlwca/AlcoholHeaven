<template>
  <div>
    <table class="table">
      <thead >
        <tr >
          <th scope="col" style="background-color: rgb(1, 173, 111);color:white ;"><h5>실시간 인기 주류🍻</h5></th>
        </tr>
      </thead>
      <tbody v-for="(alcohol, index) in sortedAlcoholList" :key="alcohol.id">
        <tr>
        <td scope="row" >
          <p v-if="alcohol.heart != 0" style="display: inline-block">
            {{ index + 1 }}위
          </p>
          &nbsp;
          <RouterLink
            :to="{
              name: 'alcohol-detail',
              params: { name: alcohol.region, id: alcohol.id },
            }"
            v-if="alcohol.heart != 0"
          >
            {{ alcohol.name }}
          </RouterLink>
          <span v-if="alcohol.heart != 0">({{ alcohol.region }})</span>
        </td>
      </tr>
      </tbody>
    </table>
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
