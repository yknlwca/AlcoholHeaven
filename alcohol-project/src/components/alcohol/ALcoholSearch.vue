<template>
  <div class="text-center">
    <div class="row align-items-center">
      <div class="col-2">
        <select class="form-select" v-model="searchInfo.key">
          <option value="none">전체</option>
          <option value="name">이름</option>
          <option value="detailRegion">세부 지역</option>
          <option value="kindOf">종류</option>
        </select>
      </div>
      <div class="col-6">
        <input type="text" class="form-control" v-model="searchInfo.word" />
      </div>
      <div class="col-1">
        <button class="btn btn-outline-warning" @click="searchAlcoholList">
          검색
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useAlcoholStore } from "@/stores/alcohol";

const store = useAlcoholStore();
const searchInfo = ref({
  key: "none",
  word: "",
});
const getAlcoholList = function () {
  store.getAlcoholList(searchInfo.value);
};
</script>

<style scoped></style>
