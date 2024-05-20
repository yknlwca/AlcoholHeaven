<template>
  <br />
  <div class="container" style="width: 70%">
    <div class="mb-3">
      <b class="form-label">이름</b>
      <input
        type="text"
        class="form-control"
        placeholder="술 이름을 입력해주세요."
        v-model="newAlcohol.name"
      />
    </div>
    <div class="mb-3">
      <b class="form-label">작성자</b>
      <input
        style="width: 50%"
        type="text"
        class="form-control"
        :value="loginUser.id"
        readonly
      />
    </div>
    <div class="mb-3">
      <b class="form-label">세부 사항</b>
      <input
        style="width: 40%"
        type="text"
        class="form-control my-2"
        :value="route.params.region"
        readonly
      /><input
        style="width: 40%"
        type="text"
        class="form-control"
        placeholder="상세 지역(ex.강남구, 춘천시, 역삼동)"
        v-model="newAlcohol.detailRegion"
      /><input
        style="width: 40%"
        type="text"
        class="form-control my-2"
        placeholder="종류"
        v-model="newAlcohol.kindOf"
      /><input
        style="width: 40%"
        type="text"
        class="form-control my-2"
        placeholder="도수"
        v-model="newAlcohol.weight"
      />
    </div>
    <div class="mb-3">
      <b for="exampleFormControlTextarea1" class="form-label">소개</b>
      <textarea
        class="form-control"
        id="exampleFormControlTextarea1"
        rows="3"
        placeholder="소개하고 싶은 술에 대해 설명해주세요!"
        v-model="newAlcohol.content"
      ></textarea>
      <div class="mb-3 my-2">
        <b for="formFileMultiple" class="form-label">사진</b>
        <input
          class="form-control"
          type="file"
          id="formFileMultiple"
          @change="handleFileUpload"
        />
      </div>
    </div>
    <button
      type="button"
      class="btn btn-outline-success"
      @click="createAlcohol"
    >
      소개하기
    </button>
  </div>
</template>

<script setup>
import { useAlcoholStore } from "@/stores/alcohol";
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const store = useAlcoholStore();
const route = useRoute();
const router = useRouter();
const newAlcohol = ref({
  userId: loginUser.value.id,
  name: "",
  detailRegion: "",
  kindOf: "",
  content: "",
  region: route.params.region,
  weight: "",
});

const selectedFile = ref(null);

const handleFileUpload = (event) => {
  selectedFile.value = event.target.files[0];
};

const createAlcohol = function () {
  const formData = new FormData();
  formData.append("file", selectedFile.value);
  formData.append("userId", newAlcohol.value.userId);
  formData.append("name", newAlcohol.value.name);
  formData.append("detailRegion", newAlcohol.value.detailRegion);
  formData.append("kindOf", newAlcohol.value.kindOf);
  formData.append("content", newAlcohol.value.content);
  formData.append("region", newAlcohol.value.region);
  formData.append("weight", newAlcohol.value.weight);
  store.createAlcohol(formData, route.params.region);
};
</script>

<style scoped></style>
