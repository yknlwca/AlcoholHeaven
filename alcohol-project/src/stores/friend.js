import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';
import { useRouter } from 'vue-router';

const REST_FRIEND_API = `http://localhost:8080/api/friend`;

export const useFriendStore = defineStore('friend', () => {
  const router = useRouter();
  const createFriend = function (friend) {
    axios({
      url: REST_FRIEND_API,
      method: 'POST',
      data: friend
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
      })
  };

  const updateFriend = function (id, friend) {
    axios.put(`${REST_FRIEND_API}/${id}`, friend)
      .then(() => {
        router.push({ name: 'friendDetail', params:{id: id} })
      })
  };
  const deleteFriend = function(id){
    axios.delete(`${REST_FRIEND_API}/${id}`)
    .then(()=>{
      router.push({name:'friendList'})
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
});
