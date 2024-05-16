import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

export const useAlcoholStore = defineStore('alcohol', () => {
  const REST_ALCOHOL_API = 'http://localhost:8080/api/alcohol'
  const alcoholList = ref([])
  const getAlcoholList = function(region){
    axios.get(`${REST_ALCOHOL_API}/${region}`)
    .then((response)=>{
      alcoholList.value = response.data
    })
  }
  const searchAlcoholList= function(condition){
    axios.get(`${REST_ALCOHOL_API}/search`,{
      params: condition
    }).then((response)=>{
      alcoholList.value = response.data.filter((alcohol)=>alcohol.region===localStorage.getItem('name'))
    })
  }
  const alcohol = ref(null)
  const alcoholDetail = function(id){
    axios.get(`${REST_ALCOHOL_API}/detail/${id}`)
    .then((response)=>{
      alcohol.value = response.data
    })
  }
  const createAlcohol = function(alcohol){
    axios({
      url:REST_ALCOHOL_API,
      method: 'POST',
      data: alcohol,
    })
    .then(()=>{
      router.push({name:'alcohol-list'})
    })
    .catch(err)=>{
      console.log(err)
    }
  }
  return {alcoholList,getAlcoholList,searchAlcoholList}
})
