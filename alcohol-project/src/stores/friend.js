import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
import { useRouter } from 'vue-router';

const REST_FRIEND_API = `http://localhost:8080/api/friend`;

export const useFriendStore = defineStore('friend', () => {
  const router = useRouter();
  const createFriend = function (formData) {
    axios({
      url: `${REST_FRIEND_API}/file`,
      method: 'POST',
      data: formData,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(() => {
        router.push({ name: 'friendList' })
      })
      .catch((error) => {
        console.log(error);
      })
  };

  const friendList = ref([]);
  const getFriendList = function () {
    axios.get(REST_FRIEND_API)
      .then((response) => {
        friendList.value = response.data;
      })
  };

  const friend = ref({});

  const getFriend = function (id) {
    // 경로 정리 필요
    axios.get(REST_FRIEND_API + "/detail/" + `${id}`)
      .then((response) => {
        friend.value = response.data;
      })
  };

  const searchFriendList = function (searchCondition) {
    axios.get(`${REST_FRIEND_API}/search`, {
      params: searchCondition
    })
      .then((response) => {
        friendList.value = response.data;
        router.push({name:'friendList',query:{key:searchCondition.key, word: searchCondition.word,}})
      })
  };

  const updateFriend = function (id, formData) {
    axios({
      url: `${REST_FRIEND_API}/file/${id}`,
      method: 'PUT',
      data: formData,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(() => {
        router.push({ name: 'friendDetail', params: { id: id } });
      })
      .catch((error) => {
        console.error("There was an error updating the food item:", error);
      });
  };

  const deleteFriend = function (id) {
    axios.delete(`${REST_FRIEND_API}/${id}`)
      .then(() => {
        router.push({ name: 'friendList' })
      })
  }

  return {
    friend,
    friendList,
    getFriend,
    searchFriendList,
    updateFriend,
    createFriend,
    getFriendList,
    deleteFriend,
  }
},{
  persist: true,
},);
