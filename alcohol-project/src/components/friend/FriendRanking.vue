<template>
  <div>
    <table class="table">
      <thead class="table-success">
        <tr>
          <th scope="col" style="background-color: rgb(1, 173, 111);color:white ;"> <h5>실시간 인기 쟁이💑</h5></th>
        </tr>
      </thead>
      <tbody v-for="(friend, index) in sortedFriendList" :key="friend.id">
        <tr>
        <td scope="row" >
          <p v-if="friend.heart != 0" style="display: inline-block">
            {{ index + 1 }}위
          </p>
          &nbsp;
          <RouterLink :to="`/friend/${friend.id}`" v-if="friend.heart != 0">
          <b>{{ friend.title }}</b>
          </RouterLink>
          <span v-if="friend.heart != 0">({{ friend.region }})</span>
        </td>
      </tr>
      </tbody>
    </table>
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
    friend.heart = await likeStore.likeCnt(3, friend.id);
  });

  await Promise.all(heartPromises);

  // heart 값으로 정렬
  friendList.value.sort((a, b) => b.heart - a.heart);
  // console.log(friendList.value);
};

onMounted(fetchFriendData);

const sortedFriendList = computed(() => {
  return friendList.value.slice(0, 5);
});
friendList.value.sort((a, b) => b.heart - a.heart);
</script>

<style scoped>
* {
  font-family: "Palatino Linotype", "Book Antiqua";
  font-weight: bold;
}
a {
  color: rgb(3, 130, 84);
  text-decoration: none;
}
</style>
