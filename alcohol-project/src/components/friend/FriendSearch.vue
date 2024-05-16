<template>
  <div class="text-center">
    <div class="row align-items-center">
      <div class="col-2">
        <select class="form-select" v-model="searchInfo.key">
          <option value="none">전체</option>
          <option value="userId">아이디</option>
          <option value="region">세부 지역</option>
          <option value="kindOf">좋아하는 술</option>
        </select>
      </div>
      <div class="col-8">
        <input type="text" class="form-control" v-model="searchInfo.word" />
      </div>
      <div class="col-2">
        <button class="btn btn-success" @click="searchFriendlList">검색</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useFriendStore } from '@/stores/friend';

const store = useFriendStore();
const searchInfo = ref({
    key: "none",
    word: "",
});

const searchFriendList = function () {
    store.searchFriendList(searchInfo.value);
};

</script>

<style scoped>

</style>