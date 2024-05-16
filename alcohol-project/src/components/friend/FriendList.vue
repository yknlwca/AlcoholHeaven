<template>
  <div class="container my-2">
    <h2>술 친구 찾기</h2>
    <hr />
    <div class="container d-flex justify-content-center">
      <FriendSearch style="width: 80%" />
    </div>
    <br />
    <table class="table text-center p-2">
      <tr>
        <th
          style="
            width: 5%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          번호
        </th>
        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          작성자
        </th>
       
        <th
          style="
            width: 30%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          제목
        </th>
        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          지역
        </th>
        <th
          style="
            width: 15%;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
          "
        >
          좋아하는 술
        </th>
        <th style="width: 15%; border-bottom: 1px solid black">좋아요</th>
      </tr>
      <tr v-for="friend in currentPageFriendList" :key="friend.id">
        <td style=" border-right: 1px solid black">
          {{ friend.id }}
        </td>
        <td class="p-2" style="border-right: 1px solid black">
          {{friend.userId }}
        </td>
        <td style="border-right: 1px solid black">
          <RouterLink :to="`/friend/${friend.id}`">
          {{ friend.title }}
        </RouterLink>
        </td>
        <td style="border-right: 1px solid black">
            {{ friend.region }}
        </td>
        <td style="border-right: 1px solid black">
          {{ friend.kindOf }}
        </td>
        <td style="width: 15%">{{ friend.heart }}</td>
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
import { useFriendStore } from "@/stores/friend";
import { computed, onMounted, ref } from "vue";
import FriendSearch from "@/components/friend/FriendSearch.vue";

const store = useFriendStore();

onMounted(() => {
  store.getFriendList();
});

const perPage = 10;
const currentPage = ref(1);

const pageCount = computed(() => {
  return Math.ceil(store.friendList.length / perPage);
});

const clickPage = function (page) {
  currentPage.value = page;
};

const currentPageFriendList = computed(() => {
  return store.friendList.slice(
    (currentPage.value - 1) * perPage,
    currentPage.value * perPage
  );
});
</script>

<style scoped></style>
