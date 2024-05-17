import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

import axios from 'axios';
import { useRouter } from 'vue-router';


const REST_FOOD_API = `http://localhost:8080/api/food`;

export const useFoodStore = defineStore('food', () => {
  const router = useRouter();
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
    axios.get(REST_FOOD_API + "/detail/" + `${id}`)
      .then((response) => {
        food.value = response.data;
      })
  };


  const updateFood = function () {
    axios.put(REST_FOOD_API, food.value)
      .then(() => {
        router.push({ name: 'foodDetail', params:{id: food.value.id} })
      })
  };



  return {
    food,
    foodList,
    updateFood,
    searchFoodList,
    getFoodList,
    createFood,
    getFood,
  }
});
