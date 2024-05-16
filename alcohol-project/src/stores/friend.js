import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';

const REST_FRIEND_API = `http://localhost:8080/api/friend`;
const REST_REVIEW_API = `http://localhost:8080/api/review`;

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
    // 경로 정리 필요
    axios.get(REST_FRIEND_API + "/detail/" + `${id}`)
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

  // 리뷰
  const reviewList = ref([]);

  const review = ref({});

  const getReviewList = function (id) {
    // 친구리뷰는 type 3로 할게
    axios.get(REST_REVIEW_API + "/3/" + `${id}`)
      .then((response) => {
        console.log(response);
        reviewList.value = response.data;

      })
      .catch((error) => {
        console.log(error);
      })
  };

  const deleteReview = function (userId, id) {
    axios
      .delete(`${REST_REVIEW_API}/${id}`)
      .then(() => {
        // 삭제 후 리뷰 목록 갱신
        getReviewList(id);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const createReview = function (review, curr) {
    axios({
      url: REST_REVIEW_API,
      method: 'POST',
      data: review
    })
      .then(() => {
        getReviewList(curr);
      })
      .catch((error) => {
        console.log(error);
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
    reviewList,
    review,
    getReviewList,
    deleteReview,
    createReview

  }
});
