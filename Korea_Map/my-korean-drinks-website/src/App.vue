<!-- App.vue -->

<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
</script>

<style>
/* 전역 스타일링 */
body {
  font-family: Arial, sans-serif;
}
</style>
