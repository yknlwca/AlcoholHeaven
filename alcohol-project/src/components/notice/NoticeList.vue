<template>
  <br />
  <div class="container my-2">
    <div class="container d-flex justify-content-center">
      <NoticeSearch style="width: 60%" />
    </div>
    <br />
    <table class="table text-center p-2">
      <tr>
        <th
          style="
            width: 20%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          번호
        </th>
        <th
          style="
            width: 60%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          내용
        </th>

        <th style="width: 20%; border-bottom: 1px solid black">작성자</th>
      </tr>
      <tr v-for="notice in currentPageNoticeList" :key="notice.id">
        <td style="border-right: 1px solid black">
          {{ notice.id }}
        </td>
        <td class="p-2" style="border-right: 1px solid black">
          <RouterLink :to="`/notice/${notice.id}`" class="text-truncate">
            {{ notice.content }}
          </RouterLink>
        </td>
        <td style="border-right: 1px solid black">
          {{ notice.userId }}
        </td>
      </tr>
    </table>
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
          :class="{ active: currentPage === page }"
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
import { computed, onMounted, ref } from "vue";
import NoticeSearch from "@/components/notice/NoticeSearch.vue";

const store = useNoticeStore();

onMounted(() => {
  store.getNoticeList();
});

const perPage = 10;
const currentPage = ref(1);

const pageCount = computed(() => {
  return Math.ceil(store.noticeList.length / perPage);
});

const clickPage = function (page) {
  currentPage.value = page;
};

const currentPageNoticeList = computed(() => {
  return store.noticeList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
</script>

<style scoped></style>
