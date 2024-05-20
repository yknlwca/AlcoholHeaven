import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router'
import axios from 'axios'

export const useLikeStore = defineStore('boardLike', () => {
  const REST_LIKE_API = 'http://localhost:8080/api/boardLike'
 
  const clickLike = function (boardLike) {
    axios({
      url: `${REST_LIKE_API}/click-like`,
      method: 'POST',
      data: boardLike,
    })
      .then(() => {
        console.log("좋아요 클릭")
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const removeLike = function (boardLike) {
    axios({
      url: `${REST_LIKE_API}/remove-like`,
      method: 'DELETE',
      data: boardLike,
    })
      .then(() => {
        console.log("좋아요 취소")
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const likeCnt = function(type, id){
    axios.get(`${REST_LIKE_API}/${type}/${id}`)
    .then((response)=>{
        console.log(response.data)
        return response.data;
    })
  }

  const check = function(boardLike){
    axios.get(`${REST_LIKE_API}/check`,{
        params: boardLike
    })
    .then((response)=>{
        console.log(response.data)
        return response.data;
    })
  }
  return {clickLike, removeLike, likeCnt,check }
},{
  persist: true,
},)
