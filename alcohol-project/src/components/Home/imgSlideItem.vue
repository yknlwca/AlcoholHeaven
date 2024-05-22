<template>
  <div class="carousel-item" :class="{ active: index === 0 }">
    <img
      :src="`http://localhost:8080/uploads/alcohol/${alcohol.img}`"
      class="d-block w-100"
      alt="..."
      style="width: 50%; height: 300px; border: 1px solid black"
    />
  </div>
</template>

<script setup>
const props = defineProps({
  alcohol: Object,
  index: Number,
});
</script>

<style scoped></style>
