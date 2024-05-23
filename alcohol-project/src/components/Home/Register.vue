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
        &nbsp;
        <button type="button" class="btn btn-outline-success" @click="idOk(id)">
          중복 체크
        </button>
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
          type="text"
          v-model="idNumber"
          class="form-control"
          placeholder="주민번호"
        />
        &nbsp;
        <button
          type="button"
          class="btn btn-outline-success"
          @click="isAdult(idNumber)"
        >
          성인 확인
        </button>
      </div>
      <div style="width: 50%">
        <p
          v-if="idNumber != '' && !idNumberCheck(idNumber)"
          style="margin-top: 0; font-size: 10px; color: red"
        >
          형식이 올바르지 않습니다.
        </p>
        <p
          v-if="idNumber != '' && idNumberCheck(idNumber)"
          style="margin-top: 0; font-size: 10px; color: blue"
        >
          형식이 올바릅니다.
        </p>
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          style="display: block"
          type="text"
          id="email"
          v-model="email"
          class="form-control"
          placeholder="이메일(ex.your@email.com)"
        />
      </div>
      <div style="width: 50%">
        <p
          v-if="email != '' && !emailCheck(email)"
          style="margin-top: 0; font-size: 10px; color: red"
        >
          이메일 형식이 올바르지 않습니다.
        </p>
        <p
          v-if="email != '' && emailCheck(email)"
          style="margin-top: 0; font-size: 10px; color: blue"
        >
          이메일 형식이 올바릅니다.
        </p>
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
const isOk = ref(false);
var now = new Date();
const nowYear = ref(now.getFullYear());
const adult = ref(false);
const register = () => {
  if (
    isOk &&
    id.value &&
    password.value &&
    name.value &&
    idNumber.value &&
    email.value &&
    phoneNumber.value &&
    emailCheck(email.value) &&
    isAdult(idNumber.value) &&
    idOk(id.value) &&
    idNumberCheck(idNumber.value)
  ) {
    const newUser = {
      id: id.value,
      password: password.value,
      name: name.value,
      idNumber: idNumber.value,
      email: email.value,
      phoneNumber: phoneNumber.value,
    };
    store.createUser(newUser);
  } else {
    alert("가입 정보를 확인해주세요.");
  }
};
const emailCheck = function (email_address) {
  const email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.+(com|net|kr)$/i;
  if (email_address !== "" && !email_regex.test(email_address)) {
    isOk.value = false;
    return false;
  } else {
    isOk.value = true;
    return true;
  }
};
const idNumberCheck = function (idNum) {
  const idNum_regex = /^\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{7}$/;
  if (idNum !== "" && !idNum_regex.test(idNum)) {
    isOk.value = false;
    return false;
  } else {
    isOk.value = true;
    return true;
  }
};
const isAdult = function (idNumber) {
  let plus = 0;
  if (idNumber[6] === "1" || idNumber[6] === "2") {
    plus = 1900;
  } else {
    plus = 2000;
  }
  if (nowYear.value - parseInt(idNumber.substring(0, 2), 10) - plus >= 19) {
    alert("성인입니다!");
    isOk.value = true;
    return true;
  } else {
    alert("더 크고 와라!");
    isOk.value = false;
    return false;
  }
};
const idOk = async function (id) {
  try {
    const user = await store.getUser(id);

    if (user != null) {
      isOk.value = false;
      alert("중복된 아이디가 있습니다.");
      return false;
    } else if (id.length > 20) {
      isOk.value = false;
      alert("아이디는 20자리까지 가능합니다.");
      return false;
    } else {
      isOk.value = true;
      alert("사용 가능한 아이디입니다.");
      return true;
    }
  } catch (error) {
    console.log(error);
    isOk.value = false;
    alert("아이디 확인 중 오류가 발생했습니다.");
  }
};

localStorage.removeItem("name");
</script>

<style scoped>
/* 필요한 스타일 추가 */
</style>
