<template>
  <div>
    <div id="Alcohol-img-slide" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-inner">
        <imgSlideItem
          v-for="(alcohol, index) in store.alcoholList"
          :key="alcohol.id"
          :alcohol="alcohol"
          :index="index"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import imgSlideItem from "@/components/Home/imgSlideItem.vue";
import { useAlcoholStore } from "@/stores/alcohol";
import { onMounted } from "vue";
const store = useAlcoholStore();
onMounted(() => {
  store.getAllAlcoholList();
  console.log(store.alcoholList);
});
</script>

<style scoped></style>
