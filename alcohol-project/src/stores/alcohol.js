import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

export const useAlcoholStore = defineStore('alcohol', () => {
  const REST_ALCOHOL_API = 'http://localhost:8080/api/alcohol'
  const alcoholList = ref([])
  const getAlcoholList = function (region) {
    axios.get(`${REST_ALCOHOL_API}/${region}`)
      .then((response) => {
        alcoholList.value = response.data
      })
  }
  const searchAlcoholList = function (condition) {
    axios.get(`${REST_ALCOHOL_API}/search`, {
      params: condition
    }).then((response) => {
      alcoholList.value = response.data.filter((alcohol) => alcohol.region === localStorage.getItem('name'))
    })
  }
  const alcohol = ref({})
  const alcoholDetail = function (id) {
    axios.get(`${REST_ALCOHOL_API}/detail/${id}`)
      .then((response) => {
        alcohol.value = response.data
        console.log(alcohol.value)
      })
  }
  const createAlcohol = function (formData,region) {
    axios({
      url: `${REST_ALCOHOL_API}/file`,
      method: 'POST',
      data: formData,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(() => {
        router.push({ name: 'alcohol-list', params: {name:region }})
      })
      .catch((err) => {
        console.log(err)
      })
  }
  const likeup = function (id) {
    axios.put(`${REST_ALCOHOL_API}/likeup/${id}`)
      .then((response) => {
        console.log(id)
      })
  }
  const likedown = function (id) {
    axios.put(`${REST_ALCOHOL_API}/likedown/${id}`)
      .then(() => {
        console.log(alcohol.value)
      })
  }
  const updateAlcohol = function (id,region, formData) {
    axios({
      url: `${REST_ALCOHOL_API}/file/${id}`,
      method: 'PUT',
      data: formData,
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(() => {
        router.push({ name: 'alcohol-detail', params: { id: id, name:region } });
      })
      .catch((error) => {
        console.error("There was an error updating the food item:", error);
      });
  };
  const deleteAlcohol = function(id, region){
    axios.delete(`${REST_ALCOHOL_API}/${id}`)
    .then(()=>{
      router.push({name:'alcohol-list', params:{name:region}})
    })
  }

  return { alcoholList, getAlcoholList, searchAlcoholList, alcohol, createAlcohol, likeup, likedown, updateAlcohol, alcoholDetail, deleteAlcohol  }
})
