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
  const alcohol = ref(null)
  const alcoholDetail = function (id) {
    axios.get(`${REST_ALCOHOL_API}/detail/${id}`)
      .then((response) => {
        alcohol.value = response.data
      })
  }
  const createAlcohol = function (alcohol) {
    axios({
      url: REST_ALCOHOL_API,
      method: 'POST',
      data: alcohol,
    })
      .then(() => {
        router.push({ name: 'alcohol-list', params: alcohol.value.region })
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
  const update = function (id) {
    axios.put(`${REST_ALCOHOL_API}/update/${id}`, alcohol.value)
      .then(() => {
        router.push({ name: 'alcohol-list', params: alcohol.value.region })
      })
  }

  return { alcoholList, getAlcoholList, searchAlcoholList, alcohol, createAlcohol, likeup, likedown, update, alcoholDetail }
})
