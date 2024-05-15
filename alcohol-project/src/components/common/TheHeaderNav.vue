<template>
  <div class="container text-center">
    <RouterLink to="/"
      ><img src="@/assets/img/알코올천국로고_최종.png" alt="알코올천국입니다!"
    /></RouterLink>
  </div>
  <nav>
    <div :class="alcohol">
      <RouterLink to="/alcohol">지역별 술 찾기</RouterLink>
    </div>
    <div :class="food">
      <RouterLink :to="{ name: 'food' }">안주 찾기</RouterLink>
    </div>
    <div :class="friend">
      <RouterLink :to="{ name: 'friendList' }">친구 찾기</RouterLink>
    </div>
    <div :class="notice">
      <RouterLink :to="{ name: 'notice' }">공지사항</RouterLink>
    </div>
  </nav>
</template>

<script setup>
import { ref, computed } from "vue";
import { useRoute } from "vue-router";
const route = useRoute();
const alcohol = computed(() => {
  if (route.name === "alcohol") return { active: true };
});
const food = computed(() => {
  if (route.name === "food") return { active: true };
});
const friend = computed(() => {
  if (route.name === "friend") return { active: true };
});
const notice = computed(() => {
  if (route.name === "notice") return { active: true };
});
</script>

<style scoped>
nav div {
  width: 200px;
  background-color: rgb(1, 173, 111);
  text-align: center;
  height: 85px;
}
nav a {
  text-decoration: none;
  color: white;
  line-height: 85px;
  font-size: 24px;
  font-weight: bold;
}
nav {
  display: flex;
  justify-content: center;
  gap: 30px;
  background-color: rgb(1, 173, 111);
}
nav div:hover {
  background-color: rgb(3, 130, 84);
}
.active {
  background-color: rgb(3, 130, 84);
}
</style>
