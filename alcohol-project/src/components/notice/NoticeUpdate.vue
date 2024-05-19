<template>
    <br />
    <div class="container" style="width: 70%">
      <div class="mb-3">
        <b class="form-label">제목</b>
        <input
          type="text"
          class="form-control"
          :placeholder="store.notice.title"
          v-model="newNotice.title"
        />
      </div>
      <div class="mb-3">
        <b class="form-label">작성자</b>
        <input
          style="width: 50%"
          type="text"
          class="form-control"
          value="admin"
          readonly
        />
      </div>
      <div class="mb-3">
        <b for="exampleFormControlTextarea1" class="form-label">내용</b>
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
          :placeholder="store.notice.content"
          v-model="newNotice.content"
        ></textarea>
      </div>
      <button type="button" class="btn btn-outline-success" @click="updateNotice">
        수정
      </button>
    </div>
  </template>
  
  <script setup>
  import { useNoticeStore } from "@/stores/notice";
  import { ref } from "vue";
  import { useRoute } from "vue-router";
  const route = useRoute();
  const store = useNoticeStore();
  const id = ref(route.params.id)
  const newNotice = ref({
    userId: 'admin',
    content: store.notice.content,
    title: store.notice.title,
    password: '1234'
  });
  const updateNotice = function () {
    store.updateNotice(id.value,newNotice.value);
  };
  </script>
  
  <style scoped></style>
  