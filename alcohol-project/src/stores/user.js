import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios';

const REST_USER_API = `http://localhost:8080/api/user`;

export const useUserstore = defineStore('user', () => {

  const signIn = ref(false);

  // const createUser = function (user) {
  //   axios({
  //     url: REST_USER_API,
  //     method: 'POST',
  //     data: user
  //   })
  //     .then(() => {
  //       alert('회원가입 성공!!')
  //       router.push({ name: `home` })
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //       alert('가입정보를 다시 확인해주세요.');
  //     })
  // };

  const createUser = async (user) => {
    try {
      await axios.post(REST_USER_API, user);
      alert('회원가입 성공!!');
      router.push({ name: 'home' });
    } catch (error) {
      if (error.response && error.response.status === 400) {
        alert('ID가 이미 존재합니다.');
      } else {
        console.log(error);
        alert('가입정보를 다시 확인해주세요.');
      }
    }
  };

  const userList = ref([]);
  const getUserList = function () {
    axios.get(REST_USER_API)
      .then((response) => {
        console.log(response);
        userList.value = response.data;
      })
      .catch((error) => {
        console.log(error);
      })
  };


  const getUser = async (id) => {
    try {
      const response = await axios.get(`${REST_USER_API}/${id}`);
      user.value = response.data;
      return user.value;
    } catch (error) {
      console.log(error);
      return null;
    }
  };

  const user = ref({});

  const updateUser = function () {
    axios.put(REST_USER_API, user.value)
      .then(() => {
        router.push({ name: `home` });
      })
  }

  const setSignIn = (status) => {
    signIn.value = status;
    sessionStorage.setItem('signIn', status.toString());
  }

  return {
    updateUser,
    userList,
    user,
    createUser,
    getUserList,
    getUser,
    signIn,
    setSignIn,

  }
})
