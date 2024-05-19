import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

import axios from 'axios';
import { useRouter } from 'vue-router';


const REST_FOOD_API = `http://localhost:8080/api/food`;

export const useFoodStore = defineStore('food', () => {
  const router = useRouter();
  // food
  const createFood = function (formData) {
    axios({
      url: `${REST_FOOD_API}/file`,
      method: 'POST',
      data: formData,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(() => {
        router.push({ name: 'foodList' });
      })
      .catch((error) => {
        console.log(error);
      });
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
    axios.get(`${REST_FOOD_API}/search`, {
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


  const updateFood = function (id, food) {
    axios.put(`${REST_FOOD_API}/${id}`, food).then(() => {
      router.push({ name: 'foodDetail', params: { id: id } })
    }).catch((error) => {
      console.error("There was an error updating the food item:", error);
    });
  };
  const deleteFood = function (id) {
    axios.delete(`${REST_FOOD_API}/${id}`)
      .then(() => {
        router.push({ name: 'foodList' })
      })
  }



  return {
    food,
    foodList,
    updateFood,
    searchFoodList,
    getFoodList,
    createFood,
    getFood,
    deleteFood,
  }
});
