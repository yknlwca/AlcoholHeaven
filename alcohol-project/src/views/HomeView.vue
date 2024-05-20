<script setup>
import Login from "@/components/Home/Login.vue";
import Home from "@/components/Home/Home.vue";
localStorage.removeItem("name");
</script>

<template>
  <!--세션에 로그인 유저가 null이면 로그인창-->
  <Login />
  <!--로그인 유저가 null이 아니면 다른 창-->
  <Home />
</template>
