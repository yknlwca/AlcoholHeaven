<script setup>
import { ref, watch, computed, onMounted } from "vue";
import axios from "axios";

const totalArticle = ref(0);
const currentPage = ref(1);
const articleList = ref([]);
const currentList = ref([]);

onMounted(() => {
  axios.get("/data.json").then((res) => {
    totalArticle.value = res.data.length;
    articleList.value = res.data;

    currentList.value = articleList.value.slice(0, 10);
  });
});

const lastPage = computed(() => {
  return Math.ceil(totalArticle.value / 10);
});

function prev() {
  if (currentPage.value != 1) {
    currentPage.value -= 1;
  }
}

function next() {
  if (currentPage.value != lastPage.value) {
    currentPage.value += 1;
  }
}

function changePage(num) {
  if (num != "") {
    currentPage.value = num;
  }
}

watch(currentPage, (num) => {
  currentList.value = articleList.value.slice(10 * (num - 1), 10 * num);
});

const pageButtonList = computed(() => {
  let part = Math.ceil(currentPage.value / 5) * 5;
  let array = [];
  for (let i = part - 4; i <= part; i++) {
    if (i > lastPage.value) {
      array.push("");
    } else {
      array.push(i);
    }
  }
  return array;
});
</script>

<template>
  <div class="about">
    <h1>Pagination</h1>
    <p>총 게시글 수 : {{ totalArticle }}</p>

    <div class="articleList">
      <div v-for="article in currentList" class="article">
        <p>{{ article.no }}</p>
        <img :src="article.url" />
      </div>
    </div>

    <div class="pagination">
      <button class="arrow clickable" @click="prev"><</button>
      <button
        @click="changePage(num)"
        :class="{ clickable: num != '' }"
        v-for="num in pageButtonList"
      >
        {{ num }}
      </button>
      <button class="arrow clickable" @click="next">></button>
    </div>
    <p>현재 페이지 : {{ currentPage }} / {{ lastPage }}</p>
  </div>
</template>

<style scoped>
h1 {
  font-size: 50px;
}

p {
  margin: 0;
}

.about {
  padding-left: 50px;
}

.title {
  width: 400px;
}

.pagination {
  display: flex;
  justify-content: center;
  margin: 5px;
  height: 25px;
}

button {
  background-color: rgb(255, 255, 255);
  font-size: 15px;
  border: solid 2px rgb(226, 235, 255);
  border-radius: 10%;
  padding: 0;
  margin-left: 5px;
  margin-right: 5px;
  width: 25px;
  display: flex;
  align-items: center;
  justify-content: center;
}

.arrow {
  width: 50px;
}

.articleList {
  display: flex;
  flex-wrap: wrap;
}

.article {
  display: flex;
  width: 300px;
  height: 200px;
  border: 1px solid rgb(189, 189, 189);
  border-radius: 5px;
  flex-direction: column;
  margin: 10px;
  padding: 10px;
  align-items: center;
  justify-content: space-between;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
}

.article:hover {
  box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
}

.clickable {
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
}

.article img {
  max-height: 180px;
  max-width: 250px;
}
</style>
