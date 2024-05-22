<template>
  <div class="main" v-if="store.signIn === false">
    <span style="color: #01AD6F;">외로운 사람들 모여라!</span>
  </div>
  <div
    class="container d-flex flex-column align-items-center justify-content-center my-5"
    v-if="store.signIn === false"
  >
    <form
      action=""
      style="width: 100%"
      class="d-flex flex-column align-items-center my-5"
    >
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="text"
          class="form-control"
          placeholder="아이디"
          v-model="id"
        />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input
          type="password"
          class="form-control"
          placeholder="비밀번호"
          v-model="password"
        />
      </div>
      <div class="d-flex" style="width: 50%">
        <button type="button" class="btn btn-outline-secondary" @click="login">
          로그인
        </button>
        <button type="button" class="btn btn-outline-success" @click="register">
          회원가입
        </button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useUserstore } from "@/stores/user";
import { useRouter } from "vue-router";

const router = useRouter();
const store = useUserstore();

const id = ref("");
const password = ref("");

const login = async () => {
  try {
    const userCredentials = { id: id.value, password: password.value };
    await store.login(userCredentials);
    router.push({ name: "home" });
  } catch (error) {
    if (error.message === "ID or password") {
      alert("아이디 또는 비밀번호가 잘못되었습니다.");
    } else {
      console.error("로그인 중 오류 발생:", error);
      alert("로그인 중 오류가 발생했습니다.");
    }
  }
  id.value = "";
  password.value = "";
};

onMounted(() => {
  store.setSignIn(sessionStorage.getItem("signIn") === "true");
});

const register = () => {
  router.push({ name: "register" });
};
</script>

<style scoped>
@keyframes mymove {
  from {
    left: 0px;
  }
  to {
    left: 70%;
  }
}

.main {
  display: inline-block;
  /* width: 100%; */
  /* height: 100px; */
  /* margin: 1em; */
  font-size: 50px;
  position: relative;
  animation: mymove 5s forwards;
}
</style>
