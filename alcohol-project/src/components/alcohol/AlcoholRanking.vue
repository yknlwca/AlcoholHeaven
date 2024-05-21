<template>
    <div>
       이달의 술 
       <p v-for="i in 10" :key="i">{{ alcoholList[i].name }}</p>
    </div>
</template>

<script setup>
    import {ref, onMounted} from 'vue'
    import { useLikeStore } from '@/stores/boardLike';
    import {useAlcoholStore} from '@/stores/alcohol'

    const likeStore = useLikeStore();
    const alcoholStore = useAlcoholStore();

    alcoholStore.getAllAlcoholList();
    const alcoholList = ref(alcoholStore.alcoholList);
    alcoholList.value.forEach(alcohol => {
        alcohol.heart = likeStore.likeCnt(1,alcohol.id);
    });
    alcoholList.value.sort((a,b)=> b.heart-a.heart)
</script>

<style scoped>
    

</style>