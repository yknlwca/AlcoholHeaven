<template>
    <br />
    <div class="container" style="width: 70%">
      <div class="mb-3">
        <b class="form-label">제목</b>
        <input
          type="text"
          class="form-control"
          :placeholder="food.title"
          v-model="newFood.title"
        />
      </div>
      <div class="mb-3">
        <b class="form-label">작성자</b>
        <input
          style="width: 50%"
          type="text"
          class="form-control"
          :value = "food.userId"
          readonly
        />
      </div>
      <div class="mb-3">
        <b class="form-label">세부 사항</b>
        <input
          style="width: 30%"
          type="text"
          class="form-control"
          :placeholder="food.menu"
          v-model="newFood.menu"
        /><input
          style="width: 30%"
          type="text"
          class="form-control my-2"
          :placeholder="food.region"
          v-model="newFood.region"
        /><input
          style="width: 30%"
          type="text"
          class="form-control my-2"
          :placeholder="food.kindOf"
          v-model="newFood.kindOf"
        />
      </div>
      <div class="mb-3">
        <b for="exampleFormControlTextarea1" class="form-label">안주 소개</b>
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
          :placeholder="food.content"
          v-model="newFood.content"
        ></textarea>
        <div class="mb-3 my-2">
          <b for="formFileMultiple" class="form-label"
            >안주 사진</b
          >
          <input
            class="form-control"
            type="file"
            id="formFileMultiple"
            @change="handleFileUpload"
          />
        </div>
      </div>
      <button type="button" class="btn btn-outline-success" @click="foodUpdate">
        수정
      </button>
    </div>
  </template>
  
  <script setup>
  import { useFoodStore } from "@/stores/food";
  import { ref } from "vue";
  import { useRoute, useRouter } from "vue-router";
  const route = useRoute();
  const router = useRouter();
  const store = useFoodStore();
  const id = ref(route.params.id)
  const food = ref(store.food)
  const newFood = ref({
    userId: food.value.userId,
    menu: food.value.menu,
    content: food.value.content,
    title: food.value.title,
    region: food.value.region,
    kindOf: food.value.kindOf
  });

const selectedFile = ref(null);

const handleFileUpload = (event) => {
  selectedFile.value = event.target.files[0];
};

const foodUpdate = async () => {
  const formData = new FormData();
  formData.append('file', selectedFile.value);
  formData.append('userId', newFood.value.userId);
  formData.append('menu', newFood.value.menu);
  formData.append('content', newFood.value.content);
  formData.append('title', newFood.value.title);
  formData.append('region', newFood.value.region);
  formData.append('kindOf', newFood.value.kindOf);

  await store.updateFood(id.value, formData);
};
  </script>
  
  <style scoped></style>
  