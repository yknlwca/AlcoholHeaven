<script setup>
import { RouterLink, RouterView } from "vue-router";
import TheHeaderNav from "./components/common/TheHeaderNav.vue";
import FooterView from "@/components/common/FooterView.vue";
</script>

<template>
  <TheHeaderNav />
  <RouterView />
  <FooterView class="footer-view"/>
</template>

<style scoped>
.footer-view{
  margin-top: 200px;
}
</style>
