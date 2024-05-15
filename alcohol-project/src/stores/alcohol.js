import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

export const useAlcoholStore = defineStore('alcohol', () => {
  const REST_ALCOHOL_API = 'http://localhost:8080/drink/alcohol'
  const alcoholList = ref([])
  const getAlcoholList = function(region){
    axios.get(`${REST_ALCOHOL_API}/${region}`)
    .then((response)=>{
      alcoholList.value = response.data
    })
  }
  const searchAlcoholList= function(condition){
    axios.get(REST_ALCOHOL_API,{
      params: condition
    }).then((response)=>{
      alcoholList.value = response.data.filter((alcohol)=>alcohol.region===localStorage.getItem('name'))
    })
  }
  return {alcoholList,getAlcoholList,searchAlcoholList}
})
