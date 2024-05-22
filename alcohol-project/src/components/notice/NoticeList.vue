<template>
  <br />
  <div class="container my-2 d-flex flex-column align-items-center">
    <div class="container d-flex justify-content-center">
      <NoticeSearch style="width: 60%" />
    </div>
    <br />
    <table class="table" style="width: 70%">
      <thead>
        <tr>
          <th>번호</th>
          <th>내용</th>

          <th>작성자</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(notice, index) in currentPageNoticeList" :key="notice.id">
          <td>
            {{ index + 1 }}
          </td>
          <td>
            <RouterLink :to="`/notice/${notice.id}`" class="text-truncate">
              <b>{{ notice.title }}</b>
            </RouterLink>
          </td>
          <td>
            {{ notice.userId }}
          </td>
        </tr>
      </tbody>
    </table>
    <div style="width: 70%" v-if="loginUser.id === 'admin'">
      <button class="btn btn-outline-success" @click="createNotice">
        글쓰기
      </button>
    </div>
    <nav aria-label="Page navigation">
      <ul class="pagination d-flex justify-content-center">
        <li class="page-item">
          <a
            class="page-link"
            @click.prevent="currentPage--"
            :class="{ disabled: currentPage <= 1 }"
            href="#"
            >&lt;</a
          >
        </li>
        <li
          class="page-item"
          :class="{ active: currentPage == page }"
          v-for="page in pageCount"
          :key="page"
        >
          <a class="page-link" href="#" @click.prevent="clickPage(page)">{{
            page
          }}</a>
        </li>
        <li class="page-item">
          <a
            class="page-link"
            @click.prevent="currentPage++"
            :class="{ disabled: currentPage >= pageCount }"
            href="#"
            >&gt;</a
          >
        </li>
      </ul>
    </nav>
  </div>
</template>

<script setup>
import { useNoticeStore } from "@/stores/notice";
import { computed, onMounted, ref, onUnmounted, watch } from "vue";
import NoticeSearch from "@/components/notice/NoticeSearch.vue";
import { useRouter, useRoute } from "vue-router";

const store = useNoticeStore();
const router = useRouter();
const route = useRoute();
const currentPage = ref(localStorage.getItem("page"));
onMounted(() => {
  currentPage.value = localStorage.getItem("page");
  if (!route.query.key) {
    store.getNoticeList();
  } else {
    store.searchNoticeList({ key: route.query.key, word: route.query.word });
  }
});
onUnmounted(() => {
  // localStorage.setItem("alcohol", null);
  localStorage.setItem("page", 1);
});
const perPage = 10;

const pageCount = computed(() => {
  return Math.ceil(store.noticeList.length / perPage);
});

const clickPage = function (page) {
  localStorage.setItem("page", page);
  currentPage.value = page;
};

const currentPageNoticeList = computed(() => {
  return store.noticeList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
const createNotice = function () {
  router.push({ name: "noticeCreate" });
};
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
watch(
  () =>
    store.noticeList.slice(
      (currentPage.value - 1) * perPage,
      currentPage.value * perPage
    ),
  () => {
    // console.log(route.query);
    currentPage.value = localStorage.getItem("page");
  }
);
watch(
  () => route.query.key,
  () => {
    // console.log("바뀜");
    if (!route.query.key) {
      store.getNoticeList();
    } else {
      store.searchNoticeList({ key: route.query.key, word: route.query.word });
    }
  }
);
</script>

<style scoped>
a {
  color: rgb(3, 130, 84);
  text-decoration: none;
}
</style>
