<template>
  <div class="container d-flex justify-content-center my-5">
    <form
      @submit.prevent="register"
      style="width: 100%"
      class="d-flex flex-column align-items-center my-5"
    >
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="text"
          v-model="id"
          class="form-control"
          placeholder="아이디"
        />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="password"
          v-model="password"
          class="form-control"
          placeholder="비밀번호"
        />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="text"
          v-model="name"
          class="form-control"
          placeholder="이름"
        />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="password"
          v-model="idNumber"
          class="form-control"
          placeholder="주민번호"
        />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="email"
          v-model="email"
          class="form-control"
          placeholder="이메일"
        />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="text"
          v-model="phoneNumber"
          class="form-control"
          placeholder="전화번호"
        />
      </div>

      <div class="d-flex" style="width: 50%">
        <button type="submit" class="btn btn-outline-success">회원가입</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useUserstore } from "@/stores/user";

const store = useUserstore();

const id = ref("");
const password = ref("");
const name = ref("");
const idNumber = ref("");
const email = ref("");
const phoneNumber = ref("");

const register = () => {
  const newUser = {
    id: id.value,
    password: password.value,
    name: name.value,
    idNumber: idNumber.value,
    email: email.value,
    phoneNumber: phoneNumber.value,
  };
  store.createUser(newUser);
};
localStorage.removeItem("name");
</script>

<style scoped>
/* 필요한 스타일 추가 */
</style>
