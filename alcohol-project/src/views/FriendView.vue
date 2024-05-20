<template>
  <div>
    <RouterView />
  </div>
</template>

<script setup>
localStorage.removeItem("name");
</script>

<style scoped></style>
