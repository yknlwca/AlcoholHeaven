<template>

        <div class="container d-flex justify-content-center my-5" v-if="store.signIn === false">
    <form
      action=""
      style="width: 100%"
      class="d-flex flex-column align-items-center my-5"
    >
      <div class="input-group mb-3" style="width: 50%">
        <input type="text" class="form-control" placeholder="아이디" v-model="id" />
      </div>
      <div class="input-group mb-3" style="width: 50%">
        <input type="password" class="form-control" placeholder="비밀번호" v-model="password" />
      </div>
      <div class="d-flex" style="width: 50%;">
        <button type="button" class="btn btn-outline-secondary" @click="login">로그인</button>
        <button type="button" class="btn btn-outline-success" @click="register">회원가입</button>
      </div>
    </form>
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useUserstore } from '@/stores/user';
import { useRouter } from 'vue-router';

const router = useRouter();
const store = useUserstore();

const id = ref('');
const password = ref('');
const signIn = ref(false);

const login = async () => {
  try {
    const user = await store.getUser(id.value);
    if (user) {
      if (user.password === password.value) {
        store.setSignIn(true);
        alert('로그인 성공');
        console.log('로그인 성공:', signIn.value);
        router.push({ name: 'alcohol' });
      } else {
        alert('비밀번호가 틀렸습니다.');
      }
    } else {
      alert('사용자 ID가 존재하지 않습니다.');
    }
  } catch (error) {
    console.error('로그인 중 오류 발생:', error);
    alert('로그인 중 오류가 발생했습니다.');
  }
};

onMounted(() => {
  store.setSignIn(sessionStorage.getItem('signIn') === 'true');
  console.log(store.signIn)
});

const register = () => {
  router.push({ name: 'register' });
};
</script>

<style scoped>

</style>