<script setup>
const handleInputChange = () => {
  console.log(1);
};
</script>

<template>
  <div>
    <h1>홈뷰</h1>
    <input @change="handleInputChange" />
  </div>
</template>
