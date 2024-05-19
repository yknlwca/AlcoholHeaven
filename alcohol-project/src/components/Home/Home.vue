<template>
    <div class="container text-center" v-if="store.signIn">
        <h1>외로운 사람들 모여라!</h1>
    </div>
</template>

<script setup>
import { useUserstore } from '@/stores/user';

    const store = useUserstore()
</script>

<style scoped>

</style>