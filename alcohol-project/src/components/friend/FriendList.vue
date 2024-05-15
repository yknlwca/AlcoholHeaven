<template>
<div class="container">
    <h2>술 친구 목록</h2>
    <hr />
    <FriendSearch />
    <table class="table table-hover text-center">
      <tr>
        <th>번호</th>
        <th>닉네임</th>
        <th>아이디</th>
        <th>성별</th>
        <th>나이</th>
        <th>주종</th>
        <th>지역</th>
        <th>자기소개</th>
      </tr>
      <tr v-for="friend in currentPageFriendList" :key="friend.id">
        <td>{{ friend.id }}</td>
        <td>
          <RouterLink :to="`/friend/${friend.id}`">{{ friend.name }}</RouterLink>
        </td>
        <td>{{ friend.userId }}</td>
        <td>{{ friend.sex }}</td>
        <td>{{ friend.age }}</td>
        <td>{{ friend.kindOf }}</td>
        <td>{{ friend.region }}</td>
        <td>{{ friend.intro }}</td>
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
import { useFriendStore } from '@/stores/friend';
import { computed, onMounted, ref } from 'vue';
import FriendSearch from '@/components/friend/FriendSearch.vue';

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

<style scoped>

</style>