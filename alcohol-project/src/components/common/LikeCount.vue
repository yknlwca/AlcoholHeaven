<template>
  <span>{{ likeCount }}</span>
</template>

<script setup>
import { ref, onMounted, defineProps, computed } from "vue";
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
});

const likeCount = ref(null);

const fetchLikeCount = async () => {
  try {
    likeCount.value = await storeLike.likeCnt(props.type, props.id);
  } catch (error) {
    console.error("좋아요 수를 가져오는 중 오류 발생:", error);
  }
};

onMounted(fetchLikeCount);
</script>
