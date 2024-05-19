<template>
  <br />
  <div class="container" style="width: 70%">
    <div class="mb-3">
      <b class="form-label">제목</b>
      <input
        type="text"
        class="form-control"
        placeholder="제목을 입력해주세요."
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
        placeholder="공지사항 내용을 입력해주세요"
        v-model="newNotice.content"
      ></textarea>
    </div>
    <button type="button" class="btn btn-outline-success" @click="createNotice">
      글 쓰기
    </button>
  </div>
</template>

<script setup>
import { useNoticeStore } from "@/stores/notice";
import { ref } from "vue";
const store = useNoticeStore();
const newNotice = ref({
  userId: 'admin',
  content: "",
  title: "",
  password: '1234'
});
const createNotice = function () {
  store.createNotice(newNotice.value);
};
</script>

<style scoped></style>
