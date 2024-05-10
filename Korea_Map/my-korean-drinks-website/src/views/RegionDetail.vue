<!-- views/RegionDetail.vue -->

<template>
  <div>
    <h2>{{ region }} 소개 페이지</h2>
    <p>이곳은 {{ region }}에 관한 소개 페이지입니다.</p>
    <!-- 해당 지역의 술 목록 표시 -->
    <ul>
      <li>술 A</li>
      <li>술 B</li>
      <li>술 C</li>
    </ul>
  </div>
</template>

<script setup>
import { ref } from "vue";

const region = ref("");

// 라우터 params에서 region 값을 가져와 설정
const { params } = useRoute();
region.value = params.region;
</script>
