<template>
    <div>
       이달의 안주 
       <p v-for="i in 1" :key="i">{{ foodList[i].title }}</p>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    import { useLikeStore } from '@/stores/boardLike';
    import {useFoodStore} from '@/stores/food'

    const likeStore = useLikeStore();
    const foodStore = useFoodStore();

    foodStore.getFoodList();
    const foodList = ref(foodStore.foodList);
    foodList.value.forEach(food => {
        food.heart = likeStore.likeCnt(2,food.id);
    });
    foodList.value.sort((a,b)=> b.heart-a.heart)
</script>

<style scoped>
    

</style>