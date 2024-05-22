<template>
  <div class="container" v-if="store.signIn" style="width: 80%">
    <h1>외로운 사람들 모여라!</h1>
    <imgSlide />
    <h4>실시간 순위!</h4>
    <div class="d-flex justify-content-between">
      <AlcoholRanking style="width: 30%" />
      <FoodRanking style="width: 30%" />
      <FriendRanking style="width: 30%" />
    </div>
  </div>
</template>

<script setup>
import imgSlide from "@/components/Home/imgSlide.vue";
import AlcoholRanking from "@/components/alcohol/AlcoholRanking.vue";
import FoodRanking from "@/components/food/FoodRanking.vue";
import FriendRanking from "@/components/friend/FriendRanking.vue";
import { useUserstore } from "@/stores/user";

const store = useUserstore();
</script>

<style scoped></style>
