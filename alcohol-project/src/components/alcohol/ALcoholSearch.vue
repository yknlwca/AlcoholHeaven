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
      <div class="col-8">
        <input type="text" class="form-control" v-model="searchInfo.word" />
      </div>
      <div class="col-2">
        <button class="btn btn-success" @click="searchAlcoholList">검색</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, watch, onMounted } from "vue";
import { useAlcoholStore } from "@/stores/alcohol";
import { useRoute } from "vue-router";

const route = useRoute();
const store = useAlcoholStore();
const searchInfo = ref({
  key: "none",
  word: "",
});
const searchAlcoholList = function () {
  localStorage.setItem("page", 1);
  store.searchAlcoholList(searchInfo.value, localStorage.getItem("name"));
  searchInfo.value = { key: "none", word: "" };
};
</script>

<style scoped></style>
