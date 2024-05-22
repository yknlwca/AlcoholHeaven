<template>
  <div class="container" v-if="store.signIn">
    <div class="d-flex justify-content-center">
      <imgSlide style="width: 60%; height: 300px" />
    </div>
    <br />
    <div class="d-flex justify-content-center">
      <div class="d-flex justify-content-between" style="width: 70%">
        <AlcoholRanking />
        <FoodRanking />
        <FriendRanking />
      </div>
    </div>
  </div>
</template>

<script setup>
import imgSlide from "@/components/Home/imgSlide.vue";
import AlcoholRanking from "@/components/alcohol/AlcoholRanking.vue";
import FoodRanking from "@/components/food/FoodRanking.vue";
import FriendRanking from "@/components/friend/FriendRanking.vue";
import { useUserstore } from "@/stores/user";

import { onMounted } from "vue";

const store = useUserstore();
</script>

<style scoped></style>
