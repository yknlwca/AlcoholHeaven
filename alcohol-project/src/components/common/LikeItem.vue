<template>
  <i class="bi bi-heart-fill" :class="{ red: isLiked }" @click="toggleLike"></i>
</template>

<script setup>
import { ref, onMounted, defineProps } from "vue";
import { useLikeStore } from "@/stores/boardLike";
import axios from "axios";
const storeLike = useLikeStore();

const props = defineProps({
  id: {
    type: Number,
    required: true,
  },
  userId: {
    type: String,
    required: true,
  },
  type: {
    type: Number,
    required: true,
  },
  boardId: {
    type: Number,
    required: true,
  },
});

const isLiked = ref(false);
const boardLike = {
  id: props.id,
  userId: props.userId,
  type: props.type,
  boardId: props.boardId,
};
const checkLike = async () => {
  try {
    isLiked.value = await storeLike.check(boardLike);
  } catch (error) {
    console.error("좋아요 상태를 가져오는 중 오류 발생:", error);
  }
};
const toggleLike = async () => {
  try {
    if (isLiked.value) {
      await storeLike.removeLike(boardLike);
    } else {
      await storeLike.clickLike(boardLike);
    }
    isLiked.value = !isLiked.value;
    window.location.reload(true);
  } catch (error) {
    console.error("좋아요 상태를 변경하는 중 오류 발생:", error);
  }
};
onMounted(() => {
  checkLike();
});
</script>
<style scoped>
.red {
  color: red;
}
</style>
