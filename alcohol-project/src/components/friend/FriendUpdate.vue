<template>
    <br />
    <div class="container" style="width: 70%">
      <div class="mb-3">
        <b class="form-label">제목</b>
        <input
          type="text"
          class="form-control"
          :placeholder="friend.title"
          v-model="newFriend.title"
        />
      </div>
      <div class="mb-3">
        <b class="form-label">작성자</b>
        <input
          style="width: 50%"
          type="text"
          class="form-control"
          :value = "friend.userId"
          readonly
        />
      </div>
      <div class="mb-3">
        <b class="form-label">세부 사항</b>
        <input
          style="width: 30%"
          type="text"
          class="form-control my-2"
          :placeholder="friend.region"
          v-model="newFriend.region"
        /><input
          style="width: 30%"
          type="text"
          class="form-control my-2"
          :placeholder="friend.kindOf"
          v-model="newFriend.kindOf"
        />
      </div>
      <div class="mb-3">
        <b for="exampleFormControlTextarea1" class="form-label">자기 소개</b>
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
          :placeholder="friend.intro"
          v-model="newFriend.intro"
        ></textarea>
        <div class="mb-3 my-2">
          <b for="formFileMultiple" class="form-label"
            >안주 사진</b
          >
          <input
            class="form-control"
            type="file"
            id="formFileMultiple"
            multiple
          />
        </div>
      </div>
      <button type="button" class="btn btn-outline-success" @click="friendUpdate">
        수정
      </button>
    </div>
  </template>
  
  <script setup>
  import { useFriendStore } from "@/stores/friend";
  import { ref } from "vue";
  import { useRoute } from "vue-router";
  const route = useRoute();
  const store = useFriendStore();
  const id = ref(route.params.id)
  const friend = ref(store.friend)
  const newFriend = ref({
    userId: friend.value.userId,
    title: friend.value.title,
    intro: friend.value.intro,
    region: friend.value.region,
    kindOf: friend.value.kindOf,
    img: friend.value.img,
  });
  const friendUpdate = function () {
    store.updateFriend(id.value,newFriend.value);
  };
  </script>
  
  <style scoped></style>
  