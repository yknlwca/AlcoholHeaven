<template>
    <div>
       이달의 인기쟁이
       <p v-for="i in 1" :key="i">{{ friendList[i].title }}</p>
    </div>
</template>

<script setup>
    import {ref} from 'vue'
    import { useLikeStore } from '@/stores/boardLike';
    import {useFriendStore} from '@/stores/friend'

    const likeStore = useLikeStore();
    const friendStore = useFriendStore();

    friendStore.getFriendList();
    const friendList = ref(friendStore.friendList);
    friendList.value.forEach(friend => {
        friend.heart = likeStore.likeCnt(3,friend.id);
    });
    friendList.value.sort((a,b)=> b.heart-a.heart)
</script>

<style scoped>
    

</style>