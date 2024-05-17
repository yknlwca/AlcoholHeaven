<template>
  <div class="text-center">
    <div class="row align-items-center">
      <div class="col-2">
        <select class="form-select" v-model="searchInfo.key">
          <option value="none">전체</option>
          <option value="title">제목</option>
          <option value="menu">메뉴</option>
          <option value="region">세부 지역</option>
          <option value="kindOf">어울리는 술</option>
        </select>
      </div>
      <div class="col-8">
        <input type="text" class="form-control" v-model="searchInfo.word" />
      </div>
      <div class="col-2">
        <button class="btn btn-success" @click="searchFoodList">검색</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useFoodStore } from "@/stores/food";
import { useRoute } from "vue-router";

const route = useRoute();
const store = useFoodStore();
const searchInfo = ref({
  key: "none",
  word: "",
});
const searchFoodList = function () {
  store.searchFoodList(searchInfo.value);
};
</script>

<style scoped></style>
