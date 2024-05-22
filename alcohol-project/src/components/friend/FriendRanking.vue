<template>
  <div>
    이달의 인기쟁이
    <p v-for="friend in sortedFriendList" :key="friend.id">
      {{ friend.title }}
    </p>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from "vue";
import { useLikeStore } from "@/stores/boardLike";
import { useFriendStore } from "@/stores/friend";

const likeStore = useLikeStore();
const friendStore = useFriendStore();
const friendList = ref([]);
const fetchFriendData = async () => {
  friendList.value = [];
  await friendStore.getFriendList();
  friendList.value = friendStore.friendList;

  // heart 값을 비동기로 설정
  const heartPromises = friendList.value.map(async (friend) => {
    friend.heart = await likeStore.likeCnt(1, friend.id);
  });

  await Promise.all(heartPromises);

  // heart 값으로 정렬
  friendList.value.sort((a, b) => b.heart - a.heart);
  console.log(friendList.value);
};

onMounted(fetchFriendData);

const sortedFriendList = computed(() => {
  return friendList.value.slice(0, 1);
});
friendList.value.sort((a, b) => b.heart - a.heart);
</script>

<style scoped></style>
