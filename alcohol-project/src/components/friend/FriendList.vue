<template>
  <br />
  <div class="container d-flex flex-column align-items-center">
    <div class="container d-flex justify-content-center">
      <FriendSearch style="width: 70%" />
    </div>
    <br />
    <table class="table" style="width: 70%">
      <thead>
        <tr>
          <th scope="col">
            번호
          </th>
          <th scope="col">
            작성자
          </th>

          <th scope="col">
            제목
          </th>
          <th scope="col">
            지역
          </th>
          <th scope="col">
            좋아하는 술
          </th>
          <th scope="col">좋아요</th>
        </tr>
      </thead>
      <tbody>
      <tr v-for="(friend,index) in currentPageFriendList" :key="friend.id">
        <td scope="row">
          {{ index+1 }}
        </td>
        <td>
          {{ friend.userId }}
        </td>
        <td>
          <RouterLink :to="`/friend/${friend.id}`">
           <b>{{ friend.title }}</b>
          </RouterLink>
        </td>
        <td>
          {{ friend.region }}
        </td>
        <td>
          {{ friend.kindOf }}
        </td>
        <td>{{ friend.heart }}</td>
      </tr>
    </tbody>
    </table>
    <div style="width: 70%;">
    <button class="btn btn-outline-success" @click="createFriend">소개하기</button>
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
import {useRouter, useRoute} from 'vue-router'
const router = useRouter();

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
const createFriend = function(){
  router.push({name: 'friendCreate'})
}
</script>

<style scoped>
a {
  color: rgb(3, 130, 84);
  text-decoration: none;
}
</style>
