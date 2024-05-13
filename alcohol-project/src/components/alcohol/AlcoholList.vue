<template>
  <div>
    <h1>{{ name }}</h1>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { onMounted, ref, watch } from "vue";
const route = useRoute();
const name = ref(route.params.name);
watch(
  () => route.params.name,
  (newName) => {
    name.value = newName;
  }
);
onMounted(() => {
  name.value = route.params.name;
});
</script>

<style scoped></style>
