<script setup>
import { RouterLink, RouterView } from "vue-router";
import TheHeaderNav from "./components/common/TheHeaderNav.vue";
</script>

<template>
  <TheHeaderNav />
  <div class="container">
    <RouterView />
  </div>
</template>

<style scoped></style>
