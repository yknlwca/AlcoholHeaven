<template>
  <div>
    <h2>대한민국 지도</h2>
    <svg width="600" height="800" viewBox="0 0 600 800" @click="handleMapClick">
      <!-- 한반도 지형 -->
      <path
        d="M150,150 L200,100 L250,50 L350,50 L400,100 L450,150 L500,200 L550,250 L600,300 
             L600,800 L0,800 Z"
        @click="goToRegion('전체')"
        fill="lightblue"
        stroke="black"
        stroke-width="2"
        cursor="pointer"
      />
      <!-- 서울 -->
      <path
        d="M250,150 L300,100 L350,100 L400,150 L350,200 L300,200 Z"
        @click="goToRegion('서울')"
      />
      <!-- 경기도 -->
      <path
        d="M250,200 L300,150 L400,150 L450,200 L400,250 L300,250 Z"
        @click="goToRegion('경기도')"
      />
      <!-- 강원도 -->
      <path
        d="M200,250 L250,200 L350,200 L400,250 L350,300 L250,300 Z"
        @click="goToRegion('강원도')"
      />
      <!-- 충청도 -->
      <path
        d="M150,200 L200,150 L300,150 L350,200 L300,250 L200,250 Z"
        @click="goToRegion('충청도')"
      />
      <!-- 전라도 -->
      <path
        d="M100,150 L150,100 L250,100 L300,150 L250,200 L150,200 Z"
        @click="goToRegion('전라도')"
      />
      <!-- 경상도 -->
      <path
        d="M100,200 L150,150 L250,150 L300,200 L250,250 L150,250 Z"
        @click="goToRegion('경상도')"
      />
      <!-- 제주도 -->
      <path
        d="M150,300 L200,250 L300,250 L350,300 L300,350 L200,350 Z"
        @click="goToRegion('제주도')"
      />
    </svg>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const goToRegion = (region) => {
  router.push({ name: "RegionDetail", params: { region } });
};

const handleMapClick = (event) => {
  // 지도 전체를 클릭할 때 이벤트를 무시하기 위한 처리
  if (event.target.tagName === "svg") return;
  event.stopPropagation();
};
</script>

<style scoped>
/* 지도 스타일링 */
path {
  cursor: pointer;
}
</style>
