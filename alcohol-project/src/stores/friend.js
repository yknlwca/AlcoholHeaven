import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';

const REST_FRIEND_API = `http://localhost:8080/with/friend`;

export const useFriendStore = defineStore('friend', () => {

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
    axios.get(`${REST_FRIEND_API}/${id}`)
      .then((response) => {
        friend.value = response.data;
      })
  };

  const searchFriendList = function (searchCondition) {
    axios.get(REST_FRIEND_API, {
      params: searchCondition
    })
      .then((response) => {
        friendList.value = response.data;
      })
  };

  const updateFriend = function () {
    axios.put(REST_FRIEND_API, friend.value)
      .then(() => {
        router.push({ name: 'friendList' })
      })
  };

  return {
    friend,
    friendList,
    getFriend,
    searchFriendList,
    updateFriend,
    createFriend,
    getFriendList,

  }
});
