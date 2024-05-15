<template>
    <div class="container">
        <h4>안주 추천 상세</h4>
        <hr />
        <div class="d-flex justify-content-center">
            <div class="card" style="width: 30rem">
                <div class="card-body">
                    <div class="mb-3 d-flex justify-content-between align-items-center">
                        <h4 class="card-title">{{ store.food.menu }}</h4>
                        <div class="d-flex justify-content-end">
                            <h6 class="card-subtitle mx-3 text-body-secondary">{{ store.food.writer }}</h6>
                            <h6 class="card-subtitle text-body-secondary">{{ store.food.region }}</h6>
                        </div>
                    </div>
                    <p class="card-text ">
                        {{ store.food.content }}
                    </p>
                    <div class="d-flex justify-content-center">
                        <button class="mx-3 btn btn-outline-success" @click="moveUpdate">수정</button>
                        <button class="mx-3 btn btn-outline-danger" @click="deletefood">삭제</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useFoodStore } from "@/stores/food";
import axios from "axios";
const route = useRoute();
const router = useRouter();
const store = useFoodStore();

onMounted(() => {
    store.getFood(route.params.id);
});

const moveUpdate = function () {
    router.push({ name: "foodUpdate" });
};

const deleteFood = function () {
    axios
        .delete(`http://localhost:8080/eat/food/${route.params.id}`)
        .then(() => {
            router.push({ name: "foodList" });
        })
        .catch((error) => {
            console.log(error);
         });
};
</script>
  
<style scoped></style>
  