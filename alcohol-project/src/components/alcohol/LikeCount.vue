<template>
  <li class="list-group-item">좋아요 : {{ likeCount }}</li>
</template>

<script setup>
import { ref, onMounted, defineProps, computed, watch } from "vue";
import { useLikeStore } from "@/stores/boardLike";
const storeLike = useLikeStore();
const props = defineProps({
  type: {
    type: String,
    required: true,
  },
  id: {
    type: Number,
    required: true,
  },
  likeCount: {
    type: Number,
    required: true,
  },
});
</script>
