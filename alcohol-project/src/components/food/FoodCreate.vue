<template>
  <br />
  <div class="container" style="width: 70%">
    <div class="mb-3">
      <b class="form-label">제목</b>
      <input type="text" class="form-control" placeholder="제목을 입력해주세요." v-model="newFood.title" />
    </div>
    <div class="mb-3">
      <b class="form-label">작성자</b>
      <input style="width: 50%" type="text" class="form-control" :value="loginUser.id" readonly />
    </div>
    <div class="mb-3">
      <b class="form-label">세부 사항</b>
      <input style="width: 30%" type="text" class="form-control" placeholder="메뉴이름" v-model="newFood.menu" /><input
        style="width: 30%" type="text" class="form-control my-2" placeholder="지역(ex.강남구)"
        v-model="newFood.region" /><input style="width: 30%" type="text" class="form-control my-2" placeholder="어울리는 술"
        v-model="newFood.kindOf" />
    </div>
    <div class="mb-3">
      <b for="exampleFormControlTextarea1" class="form-label">안주 소개</b>
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="나만의 안주를 소개해주세요."
        v-model="newFood.content"></textarea>
      <div class="mb-3 my-2">
        <b for="formFileMultiple" class="form-label">안주 사진</b>
        <input class="form-control" type="file" id="formFileMultiple" @change="handleFileUpload" />
      </div>
    </div>
    <button type="button" class="btn btn-outline-success" @click="createFood">
      추천하기
    </button>
  </div>
</template>

<script setup>
import { useFoodStore } from "@/stores/food";
import { ref } from "vue";
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const store = useFoodStore();
const newFood = ref({
  userId: loginUser.value.id,
  menu: "",
  content: "",
  title: "",
  region: "",
  kindOf: "",
});

const selectedFile = ref(null);

const handleFileUpload = (event) => {
  selectedFile.value = event.target.files[0];
};

const createFood = function () {
  const formData = new FormData();
  formData.append('file', selectedFile.value);
  formData.append('userId', newFood.value.userId);
  formData.append('menu', newFood.value.menu);
  formData.append('content', newFood.value.content);
  formData.append('title', newFood.value.title);
  formData.append('region', newFood.value.region);
  formData.append('kindOf', newFood.value.kindOf);
  store.createFood(formData);
};
</script>

<style scoped></style>
