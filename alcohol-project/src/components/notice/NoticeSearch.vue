<template>
    <div class="text-center">
      <div class="row align-items-center">
        <div class="col-2">
          <select class="form-select" v-model="searchInfo.key">
            <option value="none">전체</option>
            <option value="내용">내용</option>
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
  import { useNoticeStore } from "@/stores/notice";
  import { useRoute } from "vue-router";
  
  const route = useRoute();
  const store = useNoticeStore();
  const searchInfo = ref({
    key: "none",
    word: "",
  });
  const searchNoticeList = function () {
    store.searchNoticeList(searchInfo.value);
  };
  </script>
  
  <style scoped></style>
  