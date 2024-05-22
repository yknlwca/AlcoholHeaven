<template>
  <div class="container" v-if="store.signIn">
    <div class="d-flex justify-content-center">
      <imgSlide style="width: 60%; height: 300px" />
    </div>
    <br />
    <div class="d-flex justify-content-center">
      <div class="ranking" style="width: 70%;">
        <AlcoholRanking  style="width: 33%;" />
        <FoodRanking  style="width: 33%;"/>
        <FriendRanking  style="width: 33%;"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import imgSlide from "@/components/Home/imgSlide.vue";
import AlcoholRanking from "@/components/alcohol/AlcoholRanking.vue";
import FoodRanking from "@/components/food/FoodRanking.vue";
import FriendRanking from "@/components/friend/FriendRanking.vue";
import FooterView from "@/components/common/FooterView.vue";
import { useUserstore } from "@/stores/user";

import { onMounted } from "vue";

const store = useUserstore();
</script>

<style scoped>
.ranking {
  display: flex;
  justify-content: space-evenly;
  /* padding-top: 30px; */
  gap: 50px
}

@media (max-width: 1200px) {
  .ranking {
    display: flex;
    flex-direction: column;
    /* align-items: center; */
  }
}


</style>
