import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios';

const REST_FOOD_API = `http://localhost:8080/api/food`;
const REST_REVIEW_API = `http://localhost:8080/api/review`;

export const useFoodStore = defineStore('food', () => {
  // food
  const createFood = function (food) {
    axios({
      url: REST_FOOD_API,
      method: 'POST',
      data: food
    })
      .then(() => {
        router.push({ name: `foodList` })
      })
      .catch((error) => {
        console.log(error);
      })
  };

  const foodList = ref([]);
  const getFoodList = function () {
    axios.get(REST_FOOD_API)
      .then((response) => {
        console.log(response);
        foodList.value = response.data;
      })
      .catch((error) => {
        console.log(error);
      })
  };

  const searchFoodList = function (searchCondition) {
    axios.get(REST_FOOD_API, {
      params: searchCondition
    })
      .then((response) => {
        foodList.value = response.data;
      })
  };

  const food = ref({});

  const getFood = function (id) {
    // 경로 정리 필요
    axios.get(REST_FOOD_API + "/detail/" + `${id}`)
      .then((response) => {
        food.value = response.data;
      })
  };


  const updateFood = function () {
    axios.put(REST_FOOD_API, food.value)
      .then(() => {
        router.push({ name: 'foodList' })
      })
  };


  // review
  const reviewList = ref([]);

  const review = ref({});

  const getReviewList = function (id) {
    // 음식리뷰는 type 2로 할게
    axios.get(REST_REVIEW_API + "/2/" + `${id}`)
      .then((response) => {
        console.log(response);
        reviewList.value = response.data;

      })
      .catch((error) => {
        console.log(error);
      })
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



  return {
    food,
    foodList,
    updateFood,
    searchFoodList,
    getFoodList,
    createFood,
    getFood,
    reviewList,
    review,
    getReviewList,
    createReview,
    deleteReview
  }
});
