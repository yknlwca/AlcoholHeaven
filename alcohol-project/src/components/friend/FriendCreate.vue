<template>
  <br />
  <div class="container" style="width: 70%">
    <div class="mb-3">
      <b class="form-label">제목</b>
      <input type="text" class="form-control" placeholder="제목을 입력해주세요." v-model="newFriend.title" />
    </div>
    <div class="mb-3">
      <b class="form-label">작성자</b>
      <input style="width: 50%" type="text" class="form-control" :value="loginUser.id" readonly />
    </div>
    <div class="mb-3">
      <b class="form-label">세부 사항</b>
      <input style="width: 30%" type="text" class="form-control my-2" placeholder="지역(ex.강남구)"
        v-model="newFriend.region" /><input style="width: 30%" type="text" class="form-control my-2"
        placeholder="좋아하는 술" v-model="newFriend.kindOf" />
    </div>
    <div class="mb-3">
      <b for="exampleFormControlTextarea1" class="form-label">자기 소개</b>
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="친구들에게 간단하게 소개해주세요."
        v-model="newFriend.intro"></textarea>
      <div class="mb-3 my-2">
        <b for="formFileMultiple" class="form-label">본인을 어필할 사진을 올려주세요</b>
        <input class="form-control" type="file" id="formFileMultiple" @change="handleFileUpload" />
      </div>
    </div>
    <button type="button" class="btn btn-outline-success" @click="createFriend">
      소개하기
    </button>
  </div>
</template>

<script setup>
import { useFriendStore } from "@/stores/friend";
import { ref } from "vue";
import Login from "../Home/Login.vue";
const loginUser = ref(JSON.parse(sessionStorage.getItem("loginUser")));
const store = useFriendStore();
const newFriend = ref({
  userId: loginUser.value.id,
  title: "",
  intro: "",
  region: "",
  kindOf: "",
});

const selectedFile = ref(null);

const handleFileUpload = (event) => {
  selectedFile.value = event.target.files[0];
};

const createFriend = function () {
  const formData = new FormData();
  formData.append('file', selectedFile.value);
  formData.append('userId', newFriend.value.userId);
  formData.append('title', newFriend.value.title);
  formData.append('intro', newFriend.value.intro)
  formData.append('region', newFriend.value.region);
  formData.append('kindOf', newFriend.value.kindOf);
  store.createFriend(formData);
};

</script>

<style scoped></style>
